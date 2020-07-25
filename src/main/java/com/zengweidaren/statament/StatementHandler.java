package com.zengweidaren.statament;

import com.zengweidaren.binding.MapperMethod;
import com.zengweidaren.result.DefaultResultSetHandler;
import com.zengweidaren.result.ResultSetHandler;
import com.zengweidaren.session.Configuration;
import com.zengweidaren.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StatementHandler {
    private Configuration configuration;
    private ResultSetHandler resultSetHandler;
    public StatementHandler() {

    }
    public StatementHandler(Configuration configuration ) {
        this.configuration =configuration;
        resultSetHandler = new DefaultResultSetHandler();
    }
    public <T> T query(MapperMethod mapperMethod, Object parameter) throws Exception {
    Connection connection= DBUtil.open();
        System.out.println(String.format(mapperMethod.getSql()));
        System.out.println( Integer.parseInt(String.valueOf(parameter)));
        PreparedStatement preparedStatement =connection.prepareStatement(String.format(mapperMethod.getSql(),
                Integer.parseInt(String.valueOf(parameter))));
        System.out.println(preparedStatement);
        preparedStatement.execute();
    return resultSetHandler.handle(preparedStatement,mapperMethod);
    }

}
