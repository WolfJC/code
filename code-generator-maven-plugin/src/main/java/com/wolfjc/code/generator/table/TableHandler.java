package com.wolfjc.code.generator.table;


import com.wolfjc.code.generator.config.TableConfig;

import java.util.Collection;

/**
 * 表信息处理
 *
 * @author xdd
 */
public interface TableHandler {

    TableInfo handle(TableConfig tableConfig);

    /**
     * 根据表生成表结构
     */
    Collection<TableInfo> getTables();
}
