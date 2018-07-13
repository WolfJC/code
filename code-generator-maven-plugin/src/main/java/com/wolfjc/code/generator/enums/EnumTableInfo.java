package com.wolfjc.code.generator.enums;

/**
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumTableInfo {

    TABLE_NAME("TABLE_NAME"),

    REMARKS("REMARKS");

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
