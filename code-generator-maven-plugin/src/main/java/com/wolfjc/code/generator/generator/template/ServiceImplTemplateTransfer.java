package com.wolfjc.code.generator.generator.template;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.constant.EnumPackageType;
import com.wolfjc.code.generator.table.TableInfo;
import com.wolfjc.code.generator.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * ServiceImpl 数据模板
 */
public class ServiceImplTemplateTransfer implements Transfer<CommonTemplateInfo , TableInfo>,Filler {

    private Config config;

    private Filler nextFiller;

    public ServiceImplTemplateTransfer(Config config ,Filler filler) {
        this.config = config;
        this.nextFiller = filler;
    }

    @Override
    public void fill(TemplateInfo templateInfo, TableInfo tableInfo) {
        CommonTemplateInfo serviceImplTemplate = transfer(tableInfo);
        templateInfo.setServiceImplTemplateInfo(serviceImplTemplate);
        if (nextFiller != null){
            nextFiller.fill(templateInfo , tableInfo);
        }
    }

    @Override
    public CommonTemplateInfo transfer(TableInfo tableInfo) {
        CommonTemplateInfo serviceImplTemplateInfo = new CommonTemplateInfo();
        String entityName = tableInfo.getEntityName();
        serviceImplTemplateInfo.setPackageName(config.getBasePackage() + EnumPackageType.SERVICE_IMPL.getSuffix());
        serviceImplTemplateInfo.setClassName(entityName + EnumPackageType.SERVICE_IMPL.getCamelName());
        serviceImplTemplateInfo.setEntityName(entityName);
        serviceImplTemplateInfo.setAuthor(config.getNote().getAuthor());
        serviceImplTemplateInfo.setDateTime(DefaultValueHandle.handleDenfaultDateTime(config.getNote().getDate()));
        serviceImplTemplateInfo.setClassRemarks(tableInfo.getEntityName() + "service实现层");

        Collection<String> imports = new ArrayList<>();
        importEntity(imports, entityName);
        importService(imports,entityName);
        importDao(imports,entityName);
        serviceImplTemplateInfo.setImports(imports);
        return serviceImplTemplateInfo;
    }

    private void importEntity(Collection<String> imports, String entityName) {
        String entityImport = config.getBasePackage() +EnumPackageType.ENTITY.getSuffix()+ FileUtil.PACKAGE_SEPARATOR + entityName;
        imports.add(entityImport);
    }


    private void importDao(Collection<String> imports,String entityName){
        String daoImport = config.getBasePackage() + EnumPackageType.DAO.getSuffix() +FileUtil.PACKAGE_SEPARATOR + entityName
                + EnumPackageType.DAO.getCamelName();
        imports.add(daoImport);
    }

    private void importService(Collection<String> imports,String entityName){
        String daoImport = config.getBasePackage() + EnumPackageType.SERVICE.getSuffix() + FileUtil.PACKAGE_SEPARATOR+ entityName
                + EnumPackageType.SERVICE.getCamelName();
        imports.add(daoImport);
    }
}
