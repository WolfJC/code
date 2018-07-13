package com.wolfjc.code.generator.config;

/**
 * 表配置
 * ----
 * 需要生成模板的表相关配置
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class TableConfig {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 实体名
     */
    private String entityName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
