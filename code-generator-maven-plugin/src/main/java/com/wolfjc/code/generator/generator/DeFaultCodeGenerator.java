package com.wolfjc.code.generator.generator;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.generator.template.TemplateInfo;
import com.wolfjc.code.generator.generator.template.TemplateTransferHolder;
import com.wolfjc.code.generator.table.TableInfo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DeFaultCodeGenerator extends AbstractCodeGenerator {

    public DeFaultCodeGenerator(Config config) {
        super(config);
    }

    @Override
    protected GenerateStrategy getGenerateStrategy() {
        return new FreeMarkerGenerateStrategy(config);
    }

    @Override
    protected Collection<TemplateInfo> getTemplateInfoList(Collection<TableInfo> tableInfoList) {
        TemplateTransferHolder templateTransferHolder = new TemplateTransferHolder(config);
        List<TemplateInfo> templateInfoList = tableInfoList.parallelStream()
                .map(tableInfo -> {
                    TemplateInfo templateInfo = new TemplateInfo();
                    templateTransferHolder.fill(templateInfo, tableInfo);
                    return templateInfo;
                }).collect(Collectors.toList());
        return templateInfoList;
    }
}
