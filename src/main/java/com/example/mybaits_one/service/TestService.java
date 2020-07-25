package com.example.mybaits_one.service;

import com.example.mybaits_one.dao.TestDao;
import com.example.mybaits_one.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDao testDao ;

    public TestEntity getById(Integer id){
        return testDao.getById(id);
    }

    public int insertTest(TestEntity testentity){
        return testDao.insertTest(testentity);
    }

    public List<TestEntity> getListTestEntity(TestEntity testentity){
        String [] yis = new String []{"001","002","003"};
        if(testentity.getUsername().equals("yi")){
            testentity.setDepts(yis);
            System.out.println("走了部门领导001,002,003");
        }else if (testentity.getUsername().equals("er")){
            String[] ers =new String[1];
            ers[0]="002";
            testentity.setDepts(ers);
            System.out.println("走了002");
        }


        return testDao.getListTestEntity(testentity);
    }
}