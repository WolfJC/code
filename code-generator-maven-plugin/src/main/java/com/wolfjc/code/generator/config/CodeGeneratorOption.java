package com.wolfjc.code.generator.config;

import java.util.Collection;

/**
 * 生成模板代码时需要遵循的一些规则或者选项
 *
 * @author xdd
 * @date 2018/7/11.
 */
public class CodeGeneratorOption {

    /**
     * 基础包名
     */
    private String basePackage;

    /**
     * 表名
     */
    private Collection<String> tableName;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public Collection<String> getTableName() {
        return tableName;
    }

    public void setTableName(Collection<String> tableName) {
        this.tableName = tableName;
    }
}
