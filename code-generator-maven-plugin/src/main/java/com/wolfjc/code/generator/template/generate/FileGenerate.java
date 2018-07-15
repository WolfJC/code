package com.wolfjc.code.generator.template.generate;

import com.wolfjc.code.generator.template.TemplateInfo;

/**
 *
 */
public interface FileGenerate {

    /**
     * 生成目标文件
     * @param templateInfo
     */
    void generate(TemplateInfo templateInfo);
}
