package com.wolfjc.code.generator.enums;

/**
 * 数据库的数据类型
 *
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumDbType {
    SMALLINT("SMALLINT"),
    INT("INT"),
    MEDIUMINT("MEDIUMINT"),
    TINYINT("TINYINT"),
    BIGINT("BIGINT"),
    INTEGER("INTEGER"),
    DOUBLE("DOUBLE"),
    FLOAT("FLOAT"),
    DECIMAL("DECIMAL"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP"),
    VARCHAR("VARCHAR"),
    CHAR("CHAR"),
    TEXT("TEXT"),
    BIT("BIT");


    EnumDbType(String type) {
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
