package com.zengweidaren.session;

import com.zengweidaren.executor.SimpleExecutor;

public class SqlSessionFactory {

    public SqlSession opneSession(Configuration configuration){
        return new DefaultSqlSession(configuration,new SimpleExecutor(configuration));
    }
}
