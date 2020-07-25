package com.zengweidaren;

import com.zengweidaren.mapper.UserMapper;
import com.zengweidaren.pojo.User;
import com.zengweidaren.session.Configuration;
import com.zengweidaren.session.DefaultSqlSession;
import com.zengweidaren.session.SqlSessionFactory;
import com.zengweidaren.session.SqlSessionFactoryBuild;


import java.io.InputStream;

public class TestBasitstest {


    public static void main(String[] args) throws  Exception{
        InputStream inputStream = TestBasitstest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        Configuration configuration =new Configuration();
        configuration.setInputStream(inputStream);
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuild().build(configuration);
        DefaultSqlSession SqlSession = (DefaultSqlSession) sqlSessionFactory.opneSession(configuration);
        UserMapper userMapper=SqlSession.getMapper(UserMapper.class);
        User user = userMapper.getByIds("1");
        System.out.println(user);


    }

}
