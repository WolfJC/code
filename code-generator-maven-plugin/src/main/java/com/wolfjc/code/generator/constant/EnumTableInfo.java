package com.wolfjc.code.generator.constant;

/**
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumTableInfo {

    TABLE_NAME("TABLE_NAME"),

    REMARKS("REMARKS"),

    PRIMARY_KEY("COLUMN_NAME");

    EnumTableInfo(String name) {
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
