package com.wolfjc.code.generator.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author xdd
 * @date 2018/7/12.
 */
public enum EnumFileType {

    PROPERTIES(1, "properties", "properties配置文件"),

    YAML(2, "yml", "yml配置文件"),

    JAVA(3,"java","java文件"),

    CLASS(4,"class","class文件");


    EnumFileType(int key, String suffix, String description) {
        this.key = key;
        this.suffix = suffix;
        this.description = description;
    }

    private int key;


    private String suffix;


    private String description;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 根据文件后缀确定配置文件类型
     *
     * @param fileName
     * @return
     */
    public static EnumFileType getFileType(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return null;
        }

        String suffix = StringUtils.substringAfterLast(fileName, ".");

        return Arrays.stream(EnumFileType.values())
                .filter(enumFileType -> enumFileType.getSuffix().equals(suffix))
                .findFirst()
                .get();
    }
}
