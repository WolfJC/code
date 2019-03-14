package com.wolfjc.code.generator.generator.template;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.constant.EnumJavaType;
import com.wolfjc.code.generator.constant.EnumPackageType;
import com.wolfjc.code.generator.generator.convert.CamelConvert;
import com.wolfjc.code.generator.generator.convert.Convert;
import com.wolfjc.code.generator.table.ColumnInfo;
import com.wolfjc.code.generator.table.DataTypeMapper;
import com.wolfjc.code.generator.table.TableInfo;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 表信息转实体文件模板
 */
public class EntityTemplateTransfer implements Transfer<EntityTemplateInfo , TableInfo>,Filler{


    private Convert convert = new CamelConvert();

    private Config config;

    private Filler nextFiller;

    public EntityTemplateTransfer(Config config, Filler nextFiller) {
        this.config = config;
        this.nextFiller = nextFiller;
    }

    @Override
    public void fill(TemplateInfo templateInfo, TableInfo tableInfo) {
        EntityTemplateInfo entityTemplateInfo = transfer(tableInfo);
        templateInfo.setEntityTemplateInfo(entityTemplateInfo);
        if (nextFiller != null){
            nextFiller.fill(templateInfo ,tableInfo);
        }
    }

    @Override
    public EntityTemplateInfo transfer(TableInfo tableInfo) {

        EntityTemplateInfo entityTemplateInfo = new EntityTemplateInfo();

        entityTemplateInfo.setPackageName(config.getBasePackage() + EnumPackageType.ENTITY.getSuffix());

        Collection<AttributeTemplateInfo> attributes = getAttributes(tableInfo.getColumnInfos());

        entityTemplateInfo.setAttributes(attributes);

        entityTemplateInfo.setClassName(tableInfo.getEntityName());

        entityTemplateInfo.setEntityName(tableInfo.getEntityName());

        entityTemplateInfo.setClassRemarks(tableInfo.getRemarks());

        entityTemplateInfo.setAuthor(config.getNote().getAuthor());

        entityTemplateInfo.setDateTime(DefaultValueHandle.handleDenfaultDateTime(config.getNote().getDate()));

        return entityTemplateInfo;
    }


    /**
     * 将列名转换带输出的属性
     *
     * @param columnInfos
     * @return
     */
    public Collection<AttributeTemplateInfo> getAttributes(Collection<ColumnInfo> columnInfos) {
        return columnInfos.stream()
                .map(columnInfo -> {
                    AttributeTemplateInfo attribute = new AttributeTemplateInfo();

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
