package com.wolfjc.code.generator.table;

import java.util.Collection;

/**
 * 表信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class TableInfo {

    /**
     * 表名
     */
    private String tableName;


    /**
     * 实体名
     */
    private String entityName;

    /**
     * 表备注
     */
    private String remarks;


    /**
     * 表中的列
     */
    private Collection<ColumnInfo> columnInfos;

    /**
     * '主键
     *
     * 多主键按字段顺序取第一个
     */
    private String primaryKey;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Collection<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(Collection<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
}
