package com.wolfjc.code.generator.template;

/**
 * 模板信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class TemplateInfo {

    /**
     * 实体模板信息
     */
    private EntityTemplateInfo entityTemplateInfo;

    /**
     * 服务接口模板
     */
    private CommonTemplateInfo serviceTemplateInfo;

    /**
     * dao层接口模板
     */
    private CommonTemplateInfo daoTemplateInfo;

    /**
     * 服务实现层模板
     */
    private CommonTemplateInfo serviceImplTemplateInfo;


    public EntityTemplateInfo getEntityTemplateInfo() {
        return entityTemplateInfo;
    }

    public void setEntityTemplateInfo(EntityTemplateInfo entityTemplateInfo) {
        this.entityTemplateInfo = entityTemplateInfo;
    }

    public CommonTemplateInfo getServiceTemplateInfo() {
        return serviceTemplateInfo;
    }

    public void setServiceTemplateInfo(CommonTemplateInfo serviceTemplateInfo) {
        this.serviceTemplateInfo = serviceTemplateInfo;
    }

    public CommonTemplateInfo getDaoTemplateInfo() {
        return daoTemplateInfo;
    }

    public void setDaoTemplateInfo(CommonTemplateInfo daoTemplateInfo) {
        this.daoTemplateInfo = daoTemplateInfo;
    }

    public CommonTemplateInfo getServiceImplTemplateInfo() {
        return serviceImplTemplateInfo;
    }

    public void setServiceImplTemplateInfo(CommonTemplateInfo serviceImplTemplateInfo) {
        this.serviceImplTemplateInfo = serviceImplTemplateInfo;
    }
}
