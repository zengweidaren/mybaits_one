package com.zengweidaren.result;

import com.zengweidaren.binding.MapperMethod;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 拿到结果，然后进行反射赋值
 */
public class DefaultResultSetHandler implements  ResultSetHandler{
    @Override
    public <T> T handle(PreparedStatement preparedStatement, MapperMethod mapperMethod) throws Exception {
        Object object=new DefaultObjectFactory().create(mapperMethod.getType());
        ResultSet resultSet = preparedStatement.getResultSet();
        if(resultSet.next()){
            int i = 0;
            for(Field field :object.getClass().getDeclaredFields()){
                /* 赋值通过反射方式 */
                setValue(object,field,resultSet,i);
            }
        }

        return (T) resultSet;
    }


    private void setValue(Object resultObject, Field field, ResultSet resultSet, int i) throws  Exception{
        Method setMethod=resultObject.getClass().getMethod("set"+    upperCapital(field.getName()),field.getType());
        setMethod.invoke(resultObject,getResult(field,resultSet));
    }


    private Object getResult(Field field, ResultSet resultSet) throws  Exception{
        Class<?> type =field.getType();
        if(Integer.class==type){
            return resultSet.getInt(field.getName());
        }
        if(String.class == type){
            return resultSet.getString(field.getName());
        }
        return resultSet.getString(field.getName());
    }

    private  String upperCapital(String name){
        String substring = name.substring(0, 1);
        String substring1 = name.substring(1);
        return  substring.toUpperCase()+substring;
    }


}
