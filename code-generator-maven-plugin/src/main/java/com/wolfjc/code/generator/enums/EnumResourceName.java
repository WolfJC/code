package com.wolfjc.code.generator.enums;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 静态资源文件名
 *
 * @author xdd
 * @date 2018/8/24.
 */
public enum EnumResourceName {

    MAPPER("mapper", "mybatis的mapper文件");

    EnumResourceName(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;


    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取资源文件目录
     *
     * @return
     */
    public static Collection<String> buildAllResourceDirectory() {
        return Arrays.stream(EnumResourceName.values())
                .map(EnumResourceName::getName)
                .collect(Collectors.toList());
    }
}
