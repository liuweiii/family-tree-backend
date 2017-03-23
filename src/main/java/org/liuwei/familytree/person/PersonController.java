package org.liuwei.familytree.person;

import org.liuwei.familytree.utils.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/search")
    @ResponseBody
    public Paginate<Person> searchByName(@RequestParam("name") String name,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("pageIndex") Integer pageIndex){
        return personService.searchPersonByName(name, pageSize, pageIndex);
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
