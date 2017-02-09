package org.liuwei.familytree.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by apple on 2017/2/2.
 */
@RequestMapping("/persons")
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/{id}")
    @ResponseBody
    public Person person(@PathVariable("id") String id){
        return personRepository.byId(id);
    }

    @RequestMapping("/")
    @ResponseBody
    public List<Person> persons(){
        return personRepository.list();
    }
}
