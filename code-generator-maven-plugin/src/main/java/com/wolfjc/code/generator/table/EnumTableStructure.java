package com.wolfjc.code.generator.table;

/**
 * 表结构信息字段
 *
 * @author xdd
 * @date 2018/7/12.
 */
public enum EnumTableStructure {
    /**
     * 列名
     */
    COLUMN_NAME("COLUMN_NAME"),
    /**
     * 数据类型
     */
    DATA_TYPE("TYPE_NAME"),

    /**
     * 备注
     */
    REMARKS("REMARKS"),

    /**
     * 是否自增
     */
    IS_AUTOINCREMENT("IS_AUTOINCREMENT");


    EnumTableStructure(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
