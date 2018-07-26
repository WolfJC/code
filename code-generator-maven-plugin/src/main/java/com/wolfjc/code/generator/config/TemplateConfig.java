package com.wolfjc.code.generator.config;

/**
 * 模板配置
 */
public class TemplateConfig {

    /**
     * 默认的路径配置
     */
    public static final String DEFAULT_RELATIVE_PATH = "code-generator-maven-plugin/src/main/resources/templates";
    public static final String DEFAULT_ENTITY = "entity.ftl";
    public static final String DEFAULT_SERVICE = "service.ftl";
    public static final String DEFAULT_DAO = "dao.ftl";
    public static final String DEFAULT_SERVICE_IMPL = "serviceImpl.ftl";
    public static final String DEFAULT_MAPPER = "mapper.ftl";
    public static final String DEFAULT_CONTROLLER = "controller.ftl";

    /**
     * 模板路径
     */
    public String baseTemplatePath = DEFAULT_RELATIVE_PATH;

    public String getBaseTemplatePath() {
        return baseTemplatePath;
    }

    public void setBaseTemplatePath(String baseTemplatePath) {
        this.baseTemplatePath = baseTemplatePath;
    }
}
