package com.wolfjc.code.generator.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumPackageType {
    SERVICE("service", ".service"),
    DOMAIN("domain", ".domain"),
    ENTITY("entity", ".domain.entity"),
    BO("bo", ".domain.bo"),
    VO("vo", ".domain.vo"),
    QUERY("query", ".domain.query"),
    SERVICE_IMPL("impl", ".service.impl"),
    DAO("dao", ".dao");


    EnumPackageType(String type, String suffix) {
        this.type = type;
        this.suffix = suffix;
    }

    private String type;


    private String suffix;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 生成包名
     *
     * @param basePackage
     * @param enumPackageType
     * @return
     */
    public static String buildFullPathPackageName(String basePackage, EnumPackageType enumPackageType) {
        if (StringUtils.isEmpty(basePackage)) {
            return null;
        }
        return basePackage + enumPackageType.getSuffix();
    }
}
