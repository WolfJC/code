package com.wolfjc.code.generator.config;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 生成模板代码时需要遵循的一些规则或者选项
 *
 * @author xdd
 * @date 2018/7/11.
 */
public class CodeGeneratorOption {


    public static final String BASE_PACKAGE = "codeGeneratorOption.basePackage";

    public static final String TABLE_NAME = "codeGeneratorOption.TableConfig.tableNames";

    public static final String ENITTY_NAME = "codeGeneratorOption.TableConfig.entityNames";

    /**
     * 基础包名
     */
    private String basePackage;

    private Collection<TableConfig> tableConfigs;

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }


    public Collection<TableConfig> getTableConfigs() {
        return tableConfigs;
    }

    public void setTableConfigs(Collection<TableConfig> tableConfigs) {
        this.tableConfigs = tableConfigs;
    }

    /**
     * 获取
     * @return
     */
    public Collection<String> getTableNames() {
        if (tableConfigs == null) {
            return new ArrayList<>();
        }
        return tableConfigs.stream().map(TableConfig::getTableName).collect(Collectors.toList());
    }


    /**
     * 根据表名查找对应的实体名
     *
     * @param tableName
     * @return
     */
    public String findEntityName(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return null;
        }

        return getTableConfigs().stream().filter(tableConfig -> tableConfig.getTableName().equals(tableName))
                .map(TableConfig::getEntityName)
                .findFirst().get();
    }


}
