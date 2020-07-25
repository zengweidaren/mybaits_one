package com.zengweidaren.session;

import com.zengweidaren.binding.MapperMethod;

public interface SqlSession {
    //仿照SelectOne
    <T> T selectOne(MapperMethod mapperMethod, Object var1) throws Exception;
}
