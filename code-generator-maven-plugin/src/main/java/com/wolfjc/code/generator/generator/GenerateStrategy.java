package com.wolfjc.code.generator.generator;


import com.wolfjc.code.generator.generator.template.TemplateInfo;

import java.util.Collection;

/**
 * 模板文件生成器接口
 */
public interface GenerateStrategy {

    /**
     * 生成目标文件
     *
     * @param templateInfo
     */
    void generate(TemplateInfo templateInfo);

    /**
     * 批量生成目标文件
     *
     * @param templateInfos
     */
    void generate(Collection<TemplateInfo> templateInfos);
}
