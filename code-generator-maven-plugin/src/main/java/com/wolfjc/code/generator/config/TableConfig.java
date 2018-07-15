package com.wolfjc.code.generator.config;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 表配置
 * ----
 * 需要生成模板的表相关配置
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class TableConfig {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 实体名
     */
    private String entityName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }


    public static Collection<TableConfig> reGroup(List<String> tableNames,List<String> classNames){
        if (CollectionUtils.isEmpty(tableNames)) {
            return new ArrayList<>();
        }
        if (tableNames.size() != classNames.size()){
            throw new IllegalArgumentException("表名称个数应与类名称保持一致");
        }
        Collection<TableConfig> tableConfigs = new ArrayList<>();
        TableConfig tableConfig = null;
        for (int i = 0 ;i < tableNames.size();i++){
            tableConfig = new TableConfig();
            tableConfig.setTableName(tableNames.get(i));
            tableConfig.setEntityName(classNames.get(i));
            tableConfigs.add(tableConfig);
        }
        return tableConfigs;
    }
}
