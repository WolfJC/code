package com.wolfjc.code.generator.enums;

import java.util.Date;

/**
 * java数据类型
 *
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumJavaType {
    INTEGER(Integer.class.getSimpleName()),
    LONG(Long.class.getSimpleName()),
    SHORT(Short.class.getSimpleName()),
    BYTE(Byte.class.getSimpleName()),
    STRING(String.class.getSimpleName()),
    FLOAT(Float.class.getSimpleName()),
    DOUBLE(Double.class.getSimpleName()),
    BOOLEAN(Boolean.class.getSimpleName()),
    DATE(Date.class.getSimpleName());

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
