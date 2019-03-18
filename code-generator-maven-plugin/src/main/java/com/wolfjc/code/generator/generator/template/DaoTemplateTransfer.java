package com.wolfjc.code.generator.generator.template;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.constant.EnumPackageType;
import com.wolfjc.code.generator.table.TableInfo;
import com.wolfjc.code.generator.util.FileUtil;

import java.util.ArrayList;
import java.util.Collection;

/**
 * DAO
 */
public class DaoTemplateTransfer implements Transfer<CommonTemplateInfo , TableInfo>,Filler {

    private Config config;

    private Filler filler;

    public DaoTemplateTransfer(Config config ,Filler filler) {
        this.config = config;
        this.filler = filler;
    }

    @Override
    public void fill(TemplateInfo templateInfo, TableInfo tableInfo) {
        CommonTemplateInfo commonTemplateInfo = transfer(tableInfo);
        templateInfo.setDaoTemplateInfo(commonTemplateInfo);
        if (filler != null){
            filler.fill(templateInfo ,tableInfo);
        }
    }

    @Override
    public CommonTemplateInfo transfer(TableInfo tableInfo) {
        CommonTemplateInfo daoTemplateInfo = new CommonTemplateInfo();

        daoTemplateInfo.setPackageName(config.getBasePackage() + EnumPackageType.DAO.getSuffix());

        daoTemplateInfo.setClassName(tableInfo.getEntityName()+EnumPackageType.DAO.getCamelName());

        daoTemplateInfo.setEntityName(tableInfo.getEntityName());

        daoTemplateInfo.setAuthor(config.getNote().getAuthor());

        daoTemplateInfo.setDateTime(DefaultValueHandle.handleDenfaultDateTime(config.getNote().getDate()));

        daoTemplateInfo.setClassRemarks(tableInfo.getEntityName() + " dao层接口定义");

        Collection<String> imports = new ArrayList<>();
        importEntity(imports, tableInfo.getEntityName());
        daoTemplateInfo.setImports(imports);
        return daoTemplateInfo;
    }

    private void importEntity(Collection<String> imports, String entityName) {
        String entityImport = config.getBasePackage() +EnumPackageType.ENTITY.getSuffix()+ FileUtil.PACKAGE_SEPARATOR + entityName;
        imports.add(entityImport);
    }
}
