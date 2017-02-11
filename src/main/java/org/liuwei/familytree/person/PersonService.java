package org.liuwei.familytree.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by apple on 2017/2/11.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getFatherByChildId(String childId){
        return personRepository.getByChildId("fatherId", childId);
    }
}
