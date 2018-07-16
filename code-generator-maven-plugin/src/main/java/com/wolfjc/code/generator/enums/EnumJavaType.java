package com.wolfjc.code.generator.enums;

/**
 * java数据类型
 *
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumJavaType {

    INTEGER("Integer"),
    LONG("Long"),
    SHORT("Short"),
    BYTE("Byte"),
    STRING("String"),
    FLOAT("Float"),
    DOUBLE("Double"),
    BOOLEAN("Boolean"),
    DATE("Date");

    EnumJavaType(String type) {

        this.type = type;
    }

    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
