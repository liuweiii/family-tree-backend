package org.liuwei.familytree.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 2017/2/11.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getFatherByMyId(String myId){
        return personRepository.getByMyId("fatherId", myId);
    }

    public Person getMotherByMyId(String myId){
        return personRepository.getByMyId("motherId", myId);
    }

    public Person getSpouseByMyId(String myId){
        return personRepository.getByMyId("spouseId", myId);
    }

    public List<Person> searchPersonByName(String name){
        return personRepository.searchByName(name);
    }
}
