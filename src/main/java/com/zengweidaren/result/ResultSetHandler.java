package com.zengweidaren.result;

import com.zengweidaren.binding.MapperMethod;

import java.sql.PreparedStatement;

public interface ResultSetHandler {
    public  <T> T  handle(PreparedStatement preparedStatement, MapperMethod mapperMethod)throws  Exception;
}
