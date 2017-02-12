package org.liuwei.familytree.family;

import org.liuwei.familytree.person.Person;

import java.io.BufferedWriter;
import java.util.List;

/**
 * Created by apple on 2017/2/12.
 * fields：
 *    spouse：只有一个配偶。如果同一时间（如古代中国）某人有多个配偶，该值为第一个。对于重娶正室的情况，后续扩展考虑。
 * 暂未考虑子女
 */
public class Family {
    public Person getMe() {
        return me;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public Person getSpouse() {
        return spouse;
    }

    private Person me;
    private Person father;
    private Person mother;
    private Person spouse;

    public List<Person> getChildren() {
        return children;
    }

    private List<Person> children;

    private Family(){}

    public static class Builder{
        private Person me;

        private Person father;
        private Person mother;
        private Person spouse;
        private List<Person> children;

        public Builder(Person me){
            this.me = me;
        }

        public Builder father(Person father){
            this.father = father;
            return this;
        }

        public Builder mother(Person mother){
            this.mother = mother;
            return this;
        }

        public Builder spouse(Person spouse){
            this.spouse = spouse;
            return this;
        }

        public Builder children(List<Person> children){
            this.children = children;
            return this;
        }

        public Family build(){
            Family family = new Family();
            family.me = this.me;
            family.father = this.father;
            family.mother = this.mother;
            family.spouse = this.spouse;
            family.children = this.children;
            return family;
        }
    }
}
