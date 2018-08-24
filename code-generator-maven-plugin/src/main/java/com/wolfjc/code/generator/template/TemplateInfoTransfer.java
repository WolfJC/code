package com.wolfjc.code.generator.template;

import com.wolfjc.code.generator.config.CodeGeneratorOption;
import com.wolfjc.code.generator.db.ColumnInfo;
import com.wolfjc.code.generator.db.DataTypeMapper;
import com.wolfjc.code.generator.db.TableInfo;
import com.wolfjc.code.generator.enums.EnumJavaType;
import com.wolfjc.code.generator.enums.EnumPackageType;
import com.wolfjc.code.generator.template.convert.CamelConvert;
import com.wolfjc.code.generator.template.convert.Convert;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * 将数据库的表结构信息转换为带输出的模板信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class TemplateInfoTransfer {

    /**
     * 名称转换
     */
    private Convert convert;

    /**
     * 代码生成配置
     */
    private CodeGeneratorOption codeGeneratorOption;

    public TemplateInfoTransfer(CodeGeneratorOption codeGeneratorOption) {
        this.codeGeneratorOption = codeGeneratorOption;
        this.convert = new CamelConvert();
    }

    public void setConvert(Convert convert) {
        this.convert = convert;
    }

    /**
     * 转换为模板输出信息
     *
     * @param tableInfos
     * @return
     */
    public Collection<TemplateInfo> transfer(Collection<TableInfo> tableInfos) {
        if (CollectionUtils.isEmpty(tableInfos)) {
            return new ArrayList<>();
        }
        Collection<TemplateInfo> templateInfos = tableInfos.stream()
                .map(tableInfo -> transfer(tableInfo))
                .collect(Collectors.toList());

        return templateInfos;
    }


    /**
     * 生成输出模板
     *
     * @param tableInfo
     * @return
     */
    public TemplateInfo transfer(TableInfo tableInfo) {
        TemplateInfo templateInfo = new TemplateInfo();
        //转换为实体模板信息
        EntityTemplateInfo entityTemplateInfo = transferToEntity(tableInfo);
        templateInfo.setEntityTemplateInfo(entityTemplateInfo);
        //service模板信息
        CommonTemplateInfo serviceTemplateInfo = transferToService(tableInfo);
        templateInfo.setServiceTemplateInfo(serviceTemplateInfo);
        //dao
        CommonTemplateInfo daoTemplateInfo = transferToDao(tableInfo);
        templateInfo.setDaoTemplateInfo(daoTemplateInfo);
        //serviceImpl
        CommonTemplateInfo serviceImplTemplateInfo = transferToServiceImpl(tableInfo);
        templateInfo.setServiceImplTemplateInfo(serviceImplTemplateInfo);
        //mapper
        return templateInfo;

    }

    /**
     * 转换为实体模板
     *
     * @return
     */
    public EntityTemplateInfo transferToEntity(TableInfo tableInfo) {

        EntityTemplateInfo entityTemplateInfo = new EntityTemplateInfo();

        entityTemplateInfo.setPackageName(codeGeneratorOption.getBasePackage() + EnumPackageType.ENTITY.getSuffix());

        Collection<AttributeTempalteInfo> attributes = getAttributes(tableInfo.getColumnInfos());

        entityTemplateInfo.setAttributes(attributes);

        entityTemplateInfo.setClassName(tableInfo.getEntityName());

        entityTemplateInfo.setEntityName(tableInfo.getEntityName());

        entityTemplateInfo.setClassRemarks(tableInfo.getRemarks());

        entityTemplateInfo.setAuthor(codeGeneratorOption.getAuthor());

        entityTemplateInfo.setDateTime(DefaultValueHandle.handleDenfaultDateTime(codeGeneratorOption.getDateTime()));

        return entityTemplateInfo;
    }

    /**
     * service接口模板生成
     *
     * @param tableInfo
     * @return
     */
    public CommonTemplateInfo transferToService(TableInfo tableInfo) {
        CommonTemplateInfo commonTemplateInfo = new CommonTemplateInfo();

        commonTemplateInfo.setPackageName(codeGeneratorOption.getBasePackage() + EnumPackageType.SERVICE.getSuffix());

        commonTemplateInfo.setClassName(tableInfo.getEntityName()+EnumPackageType.SERVICE.getCamelName());

        commonTemplateInfo.setEntityName(tableInfo.getEntityName());

        commonTemplateInfo.setAuthor(codeGeneratorOption.getAuthor());

        commonTemplateInfo.setDateTime(DefaultValueHandle.handleDenfaultDateTime(codeGeneratorOption.getDateTime()));

        commonTemplateInfo.setClassRemarks(tableInfo.getEntityName() + "服务接口定义");

        Collection<String> imports = new ArrayList<>();
        importEntity(imports, tableInfo.getEntityName());
        commonTemplateInfo.setImports(imports);

        return commonTemplateInfo;
    }

    /**
     * dao层接口模板生成
     *
     * @param tableInfo
     * @return
     */
    public CommonTemplateInfo transferToDao(TableInfo tableInfo) {
        CommonTemplateInfo daoTemplateInfo = new CommonTemplateInfo();

        daoTemplateInfo.setPackageName(codeGeneratorOption.getBasePackage() + EnumPackageType.DAO.getSuffix());

        daoTemplateInfo.setClassName(tableInfo.getEntityName()+EnumPackageType.DAO.getCamelName());

        daoTemplateInfo.setEntityName(tableInfo.getEntityName());

        daoTemplateInfo.setAuthor(codeGeneratorOption.getAuthor());

        daoTemplateInfo.setDateTime(defaultTime());

        daoTemplateInfo.setClassRemarks(tableInfo.getEntityName() + " dao层接口定义");

        Collection<String> imports = new ArrayList<>();
        importEntity(imports, tableInfo.getEntityName());
        daoTemplateInfo.setImports(imports);

        return daoTemplateInfo;
    }

    /**
     * 默认时间
     *
     * @return
     */
    private String defaultTime() {
        return DefaultValueHandle.handleDenfaultDateTime(codeGeneratorOption.getDateTime());
    }


    /**
     * service实现层模板生成
     *
     * @param tableInfo
     * @return
     */
    public CommonTemplateInfo transferToServiceImpl(TableInfo tableInfo) {
        CommonTemplateInfo serviceImplTemplateInfo = new CommonTemplateInfo();

        String entityName = tableInfo.getEntityName();

        serviceImplTemplateInfo.setPackageName(codeGeneratorOption.getBasePackage() + EnumPackageType.SERVICE_IMPL.getSuffix());

        serviceImplTemplateInfo.setClassName(entityName + EnumPackageType.SERVICE_IMPL.getCamelName());

        serviceImplTemplateInfo.setEntityName(entityName);

        serviceImplTemplateInfo.setAuthor(codeGeneratorOption.getAuthor());

        serviceImplTemplateInfo.setDateTime(defaultTime());

        serviceImplTemplateInfo.setClassRemarks(tableInfo.getEntityName() + "service实现层");

        Collection<String> imports = new ArrayList<>();
        importEntity(imports, entityName);
        importService(imports,entityName);
        importDao(imports,entityName);
        serviceImplTemplateInfo.setImports(imports);

        return serviceImplTemplateInfo;
    }

    /**
     * 导入实体
     *
     * @param imports
     * @param entityName
     */
    private void importEntity(Collection<String> imports, String entityName) {
        String entityImport = codeGeneratorOption.getBasePackage() +EnumPackageType.DOMAIN.getSuffix() + entityName;
        imports.add(entityImport);
    }


    private void importDao(Collection<String> imports,String entityName){
        String daoImport = codeGeneratorOption.getBasePackage() + EnumPackageType.DAO.getSuffix() + entityName
                + EnumPackageType.DAO.getCamelName();
        imports.add(daoImport);
    }

    private void importService(Collection<String> imports,String entityName){
        String daoImport = codeGeneratorOption.getBasePackage() + EnumPackageType.SERVICE.getSuffix() + entityName
                + EnumPackageType.SERVICE.getCamelName();
        imports.add(daoImport);
    }


    /**
     * 将列名转换带输出的属性
     *
     * @param columnInfos
     * @return
     */
    public Collection<AttributeTempalteInfo> getAttributes(Collection<ColumnInfo> columnInfos) {
        return columnInfos.stream()
                .map(columnInfo -> {
                    AttributeTempalteInfo attribute = new AttributeTempalteInfo();

                    EnumJavaType enumJavaType = DataTypeMapper.findDataType(columnInfo.getDataType());
                    attribute.setDataType(enumJavaType.getType());

                    attribute.setAttributeName(convert.convert(columnInfo.getColumnName()));

                    attribute.setRemarks(columnInfo.getRemarks());

                    attribute.setAutoincrement(columnInfo.getAutoincrement());

                    attribute.setColumnName(columnInfo.getColumnName());

                    return attribute;
                }).collect(Collectors.toList());

    }
}
