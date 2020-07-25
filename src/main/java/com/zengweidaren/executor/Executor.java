package com.zengweidaren.executor;

import com.zengweidaren.binding.MapperMethod;

public interface Executor {
    <T> T query(MapperMethod mapperMethod, Object parameter) throws Exception;

}
