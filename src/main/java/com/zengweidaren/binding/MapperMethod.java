package com.zengweidaren.binding;

/**
 * 吧我们解析的slq加载到类中
 * @param <T>
 */
public class MapperMethod<T> {
    //解析<select>
    private  String sql;
    //解析<resultType>
    private  Class<T> type;

    public MapperMethod() {
    }

    public MapperMethod(String sql, Class<T> type) {
        this.sql = sql;
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }



    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
}
