package com.wolfjc.code.generator.generator.template;


import com.wolfjc.code.generator.table.TableInfo;

/**
 * 填充数据接口
 */
public interface Filler {

    void  fill(TemplateInfo templateInfo, TableInfo tableInfo);
}
