package com.zengweidaren.session;

import com.zengweidaren.executor.SimpleExecutor;

public class SqlSessionFactoryBuild {

    /**
     * 读取配置文件xml
     * @param configuration
     * @return
     */
    public SqlSessionFactory build(Configuration configuration) throws Exception {
        configuration.loadConfigurations();

        return new SqlSessionFactory();
    }
}
