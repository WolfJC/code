package com.wolfjc.code.generator.db;

/**
 * 列信息
 *
 * @author xdd
 * @date 2018/7/12.
 */
public class ColumnInfo {

    /**
     * 列名
     */
    private String columnName;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否自增
     */
    private Boolean isAutoincrement;


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getAutoincrement() {
        return isAutoincrement;
    }

    public void setAutoincrement(Boolean autoincrement) {
        isAutoincrement = autoincrement;
    }
}
