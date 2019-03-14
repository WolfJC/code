package com.wolfjc.code.generator.constant;

/**
 * @author xdd
 * @date 2018/7/16.
 */
public enum EnumYesOrNo {
    YES(Boolean.TRUE,"YES"),
    NO(Boolean.FALSE,"NO");

    EnumYesOrNo(Boolean value, String name) {
        this.value = value;
        this.name = name;
    }

    private Boolean value;

    private String name;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
