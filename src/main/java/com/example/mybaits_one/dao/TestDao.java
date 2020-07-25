package com.example.mybaits_one.dao;


import com.example.mybaits_one.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestDao {

    TestEntity getById(Integer id);

    int insertTest(TestEntity testentity);

    @Select({"<script>",
            "SELECT * FROM test",
           "<where>",
            "<when test='depts!=null '>","AND depts in ",
            "<foreach collection='depts' item='depts' open='(' separator=',' close=')'>",
            "#{depts}",
            "</foreach>",
            " AND (username =#{username} or numstate &lt;&gt; '1' )",
            "</when>",
            "<when test='username!=null and depts ==null '>","AND username =#{username} ",
            "</when>",
            "</where>",
            "</script>"})
    List<TestEntity> getListTestEntity(TestEntity testentity);
}