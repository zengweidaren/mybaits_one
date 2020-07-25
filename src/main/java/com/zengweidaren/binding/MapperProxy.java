package com.zengweidaren.binding;

import com.zengweidaren.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T>  implements InvocationHandler {
    private  final DefaultSqlSession  sqlSession;
    private  final Class<T> mapperInterface;

    public MapperProxy(DefaultSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println( method.getDeclaringClass().getName()+"."+method.getName());
        MapperMethod mapperMethod= sqlSession.getConfiguration().getMapperRegistry().getKnownMappers().get(
                /*就是找到UserMapper.java的这个类的名字和方法*/
                method.getDeclaringClass().getName()+"."+method.getName()
        );
        //通过id和namespace找到了select语句
        if(null != mapperMethod){
            return  sqlSession.selectOne(mapperMethod,String.valueOf(args[0]));
        }
        return method.invoke(proxy,args);
    }

}
