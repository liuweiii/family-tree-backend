package org.liuwei.familytree.person;

/**
 * Created by apple on 2017/2/2.
 */
public class Person {
    enum Six{
        male,
        female
    }

    public String getName() {
        return name;
    }

    public Six getSix() {
        return six;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getId() {
        return id;
    }

    private String id;
    private String name;
    private Six six;
    private Person father;
    private Person mother;

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    private String introduce;

    private Person(){
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", six=" + six +
                ", father=" + father +
                ", mother=" + mother +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public static class Builder{
        private String id;

        private String name;
        private Six six;
        private Person father;
        private Person mother;
        private String introduce;

        public Builder(String id){
            this.id = id;
            this.name = "";
            this.six = Six.male;
            this.father = null;
            this.mother = null;
            this.introduce = "";
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder six(Six six){
            this.six = six;
            return this;
        }

        public Builder father(Person father){
            this.father = father;
            return this;
        }

        public Builder mother(Person mother){
            this.mother = mother;
            return this;
        }

        public Builder introduce(String introduce){
            this.introduce = introduce;
            return this;
        }

        public Person build(){
            Person p = new Person();
            p.id = this.id;
            p.name = this.name;
            p.six = this.six;
            p.father = this.father;
            p.mother = this.mother;
            p.introduce = this.introduce;
            return p;
        }
    }
}
