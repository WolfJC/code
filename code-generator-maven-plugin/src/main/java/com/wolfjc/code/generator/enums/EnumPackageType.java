package com.wolfjc.code.generator.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xdd
 * @date 2018/7/13.
 */
public enum EnumPackageType {
    SERVICE("service", ".service","Service"),
    DOMAIN("domain", ".domain",""),
    ENTITY("entity", ".domain.entity",""),
    BO("bo", ".domain.bo","BO"),
    VO("vo", ".domain.vo","VO"),
    QUERY("query", ".domain.query","Query"),
    SERVICE_IMPL("impl", ".service.impl","ServiceImpl"),
    DAO("dao", ".dao","Dao");


    EnumPackageType(String type, String suffix, String camelName) {
        this.type = type;
        this.suffix = suffix;
        this.camelName = camelName;
    }

    private String type;


    private String suffix;


    private String camelName;

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

    public String getCamelName() {
        return camelName;
    }

    public void setCamelName(String camelName) {
        this.camelName = camelName;
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
