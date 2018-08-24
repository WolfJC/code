package com.wolfjc.code.generator.config;

import com.wolfjc.code.generator.constant.Constant;

import java.io.File;

/**
 * 模板配置
 *
 * @author xdd
 */
public class TemplateConfig {


    /**
     * 默认的路径配置
     */
    public  String DEFAULT_RELATIVE_PATH = Constant.RELATIVE_RESOURCE_PATH + File.separator+"templates";
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
