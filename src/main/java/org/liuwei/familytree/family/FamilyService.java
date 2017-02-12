package org.liuwei.familytree.family;

import org.liuwei.familytree.person.Person;
import org.liuwei.familytree.person.PersonRepository;
import org.liuwei.familytree.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 2017/2/12.
 */

@Service
public class FamilyService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    public Family getMyFamily(String myId){
        Person me = personRepository.byId(myId);
        Person father = personService.getFatherByMyId(myId);
        Person mother = personService.getMotherByMyId(myId);
        Person spouse = personService.getSpouseByMyId(myId);
        List<Person> children = personRepository.getChildren(myId, me.getSix());
        return new Family.Builder(me)
                .father(father)
                .mother(mother)
                .spouse(spouse)
                .children(children)
                .build();
    }
}
