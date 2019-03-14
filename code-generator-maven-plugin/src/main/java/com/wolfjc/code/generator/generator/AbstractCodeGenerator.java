package com.wolfjc.code.generator.generator;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.generator.template.TemplateInfo;
import com.wolfjc.code.generator.table.TableInfo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

public class AbstractCodeGenerator implements CodeGenerator{

    protected Config config;

    private GenerateStrategy generateStrategy;

    public AbstractCodeGenerator(Config config) {
        this.config = config;
        this.generateStrategy = getGenerateStrategy();
    }

    public void generateCode(Collection<TableInfo> tableInfoList){

        if (CollectionUtils.isEmpty(tableInfoList)){
            return;
        }

        Collection<TemplateInfo> templateInfoList = getTemplateInfoList(tableInfoList);

        generateStrategy.generate(templateInfoList);

    }


    protected GenerateStrategy getGenerateStrategy(){
        return null;
    }

    protected Collection<TemplateInfo> getTemplateInfoList(Collection<TableInfo> tableInfoList){

        return null;
    }
}
