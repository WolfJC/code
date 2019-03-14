package com.wolfjc.code.generator.generator.template;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.constant.EnumPackageType;
import com.wolfjc.code.generator.table.TableInfo;

import java.util.ArrayList;
import java.util.Collection;

public class ServiceTemplateTransfer implements Transfer<CommonTemplateInfo , TableInfo> ,Filler {

    private Config config;

    private Filler nextFiller;

    public ServiceTemplateTransfer(Config config ,Filler filler) {
        this.config = config;
        this.nextFiller =  filler;
    }

    @Override
    public void fill(TemplateInfo templateInfo ,TableInfo tableInfo) {
        CommonTemplateInfo serviceTemplate = transfer(tableInfo);
        templateInfo.setServiceTemplateInfo(serviceTemplate);
        if (nextFiller != null){
            nextFiller.fill(templateInfo , tableInfo);
        }
    }

    @Override
    public CommonTemplateInfo transfer(TableInfo tableInfo ) {
        CommonTemplateInfo commonTemplateInfo = new CommonTemplateInfo();

        commonTemplateInfo.setPackageName(config.getBasePackage() + EnumPackageType.SERVICE.getSuffix());

        commonTemplateInfo.setClassName(tableInfo.getEntityName()+EnumPackageType.SERVICE.getCamelName());

        commonTemplateInfo.setEntityName(tableInfo.getEntityName());

        commonTemplateInfo.setAuthor(config.getNote().getAuthor());

        commonTemplateInfo.setDateTime(DefaultValueHandle.handleDenfaultDateTime(config.getNote().getDate()));

        commonTemplateInfo.setClassRemarks(tableInfo.getEntityName() + "服务接口定义");

        Collection<String> imports = new ArrayList<>();
        importEntity(imports, tableInfo.getEntityName());
        commonTemplateInfo.setImports(imports);

        return commonTemplateInfo;
    }

    /**
     * 导入实体
     *
     */
    private void importEntity(Collection<String> imports, String entityName) {
        String entityImport = config.getBasePackage() +EnumPackageType.DOMAIN.getSuffix() + entityName;
        imports.add(entityImport);
    }
}
