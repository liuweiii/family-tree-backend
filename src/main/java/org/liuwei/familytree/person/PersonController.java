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

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    @ResponseBody
    public List<Person> persons(){
        return personRepository.all();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Person person(@PathVariable("id") String id){
        return personRepository.byId(id);
    }

    @RequestMapping("/{id}/father")
    @ResponseBody
    public Person father(@PathVariable("id") String id){
        return personService.getFatherByMyId(id);
    }

    @RequestMapping("/{id}/mother")
    @ResponseBody
    public Person mother(@PathVariable("id") String id){
        return personService.getMotherByMyId(id);
    }

    @RequestMapping("/{id}/spouse")
    @ResponseBody
    public Person spouse(@PathVariable("id") String id){
        return personService.getSpouseByMyId(id);
    }
}
