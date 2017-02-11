package org.liuwei.familytree.person;

/**
 * Created by apple on 2017/2/2.
 */
public class Person {
    public String getSpouseId() {
        return spouseId;
    }

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
    private String fatherId;
    private String motherId;
    private String spouseId;

    public String getFatherId() {
        return fatherId;
    }

    public String getMotherId() {
        return motherId;
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
                ", fatherId=" + fatherId +
                ", motherId=" + motherId +
                ", spouseId=" + spouseId +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public static class Builder{
        private String id;

        private String name;
        private Six six;
        private String fatherId;
        private String motherId;
        private String introduce;
        private String spouseId;

        public Builder(String id){
            this.id = id;
            this.name = "";
            this.six = Six.male;
            this.fatherId = null;
            this.motherId = null;
            this.spouseId = null;
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

        public Builder fatherId(String father){
            this.fatherId = father;
            return this;
        }

        public Builder motherId(String mother){
            this.motherId = mother;
            return this;
        }

        public Builder spouseId(String spouse){
            this.spouseId = spouse;
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
            p.fatherId = this.fatherId;
            p.motherId = this.motherId;
            p.introduce = this.introduce;
            p.spouseId = this.spouseId;
            return p;
        }
    }
}
