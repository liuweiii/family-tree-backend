package org.liuwei.familytree.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2017/2/12.
 */
@RequestMapping("/families")
@RestController
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @RequestMapping("/{myId}")
    @ResponseBody
    public Family myFamily(@PathVariable("myId") String myId){
        return familyService.getMyFamily(myId);
    }
}
