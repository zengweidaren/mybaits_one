package com.example.mybaits_one.controller;




import com.example.mybaits_one.entity.TestEntity;
import com.example.mybaits_one.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demoproject/test")
public class TestController {

    @Autowired
    private TestService testService ;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public TestEntity test(@PathVariable Integer id){
        System.out.println("id:" + id);
        return testService.getById(id);
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insertTest(TestEntity testentity){
        return testService.insertTest(testentity);
    }
    @RequestMapping(value = "/getListTest",method = RequestMethod.POST)
    public List<TestEntity> getListTestEntity(TestEntity testentity){
        List<TestEntity> list=testService.getListTestEntity(testentity);
        for (TestEntity sdf: list
             ) {
            System.out.println(sdf.toString());
        }
        return list;
    }
}