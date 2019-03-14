package com.wolfjc.code.generator.config;

/**
 * 表相关配置
 */
public class TableConfig {

    /**
     * 表名
     */
    private String name;

    /**
     * 实体名
     */
    private String entity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
