package com.zengweidaren.session;

import com.zengweidaren.binding.MapperMethod;
import com.zengweidaren.binding.MapperProxy;
import com.zengweidaren.executor.SimpleExecutor;

import java.lang.reflect.Proxy;

public class DefaultSqlSession implements  SqlSession{
    private  Configuration configuration;
    private SimpleExecutor executor;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public SimpleExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(SimpleExecutor executor) {
        this.executor = executor;
    }

    /**
     * 构造方法进行初始化赋值
     * @param configuration
     * @param executor
     */
    public DefaultSqlSession(Configuration configuration, SimpleExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> type){
      return  (T) Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MapperProxy<>(this,type));
    }

    @Override
    public <T> T selectOne(MapperMethod mapperMethod, Object var1) throws Exception {
        return executor.query(mapperMethod,var1);
    }
}
