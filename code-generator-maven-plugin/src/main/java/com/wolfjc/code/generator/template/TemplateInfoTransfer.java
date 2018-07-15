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
        if (CollectionUtils.isEmpty(tableInfos)){
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
        //todo::service模板信息

        //todo::dao

        //todo::serviceImpl

        //todo::mapper
        return templateInfo;

    }

    /**
     * 转换为实体模板
     *
     * @return
     */
    public EntityTemplateInfo transferToEntity(TableInfo tableInfo) {

        EntityTemplateInfo entityTemplateInfo = new EntityTemplateInfo();

        entityTemplateInfo.setPackageName(codeGeneratorOption.getBasePackage() + EnumPackageType.DOMAIN);

        Collection<AttributeTempalteInfo> attributes = getAttributes(tableInfo.getColumnInfos());

        entityTemplateInfo.setAttributes(attributes);

        String entityName = codeGeneratorOption.findEntityName(tableInfo.getTableName());

        entityTemplateInfo.setClassName(entityName);

        return entityTemplateInfo;
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

                    attribute.setAttributeName(columnInfo.getColumnName());

                    attribute.setRemarks(columnInfo.getRemarks());

                    return attribute;
                }).collect(Collectors.toList());

    }
}
