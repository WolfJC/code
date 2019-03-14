package com.wolfjc.code.generator.generator.template;

/**
 * 属性的模板信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class AttributeTemplateInfo implements TemplateData{

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 属性名
     */
    private String attributeName;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否自增
     *
     */
    private Boolean isAutoincrement;

    /**
     * 数据库中的列名
     */
    private String columnName;


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
