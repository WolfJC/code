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
    public static final String DEFAULT_SERVICE_REALTIVE_PATH = DEFAULT_RELATIVE_PATH+"/service.ftl";
    public static final String DEFAULT_SERVICE_IMPL_REALTIVE_PATH = DEFAULT_RELATIVE_PATH+"/serviceImpl.ftl";
    public static final String DEFAULT_CONTROLLER_REALTIVE_PATH = DEFAULT_RELATIVE_PATH+"/controller.ftl";
    public static final String DEFAULT_DAO_REALTIVE_PATH = DEFAULT_RELATIVE_PATH+"/dao.ftl";
    public static final String DEFAULT_MAPPER_REALTIVE_PATH = DEFAULT_RELATIVE_PATH+"/mapper.ftl";

    /**
     * 实体模板文件位置
     */
    private String entityPath;

    /**
     * service模板文件路径位置
     */
    private String servicePath;

    /**
     * **ServiceImpl模板文件位置
     */
    private String serviceImplPath;

    /**
     * dao 模板文件位置
     */
    private String daoPath;

    /**
     * controller 模板文件配置
     */
    private String controllerPath;


    private String mapperPath;


    public String getEntityPath() {
        return entityPath;
    }

    public void setEntityPath(String entityPath) {
        this.entityPath = entityPath;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getServiceImplPath() {
        return serviceImplPath;
    }

    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    public String getDaoPath() {
        return daoPath;
    }

    public void setDaoPath(String daoPath) {
        this.daoPath = daoPath;
    }

    public String getControllerPath() {
        return controllerPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }
}
