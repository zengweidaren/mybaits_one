package com.zengweidaren.executor;

import com.zengweidaren.binding.MapperMethod;
import com.zengweidaren.session.Configuration;
import com.zengweidaren.statament.StatementHandler;

public class SimpleExecutor implements  Executor{
    private  Configuration configuration;
    public SimpleExecutor(Configuration configuration) {
        this.configuration=configuration;
    }

    @Override
    public <T> T query(MapperMethod mapperMethod, Object parameter) throws Exception {
        System.out.println("--------SimpleExecutor.query()方法----------------");
        StatementHandler statementHandler =new StatementHandler();
        return statementHandler.query(mapperMethod,parameter);
    }
}
