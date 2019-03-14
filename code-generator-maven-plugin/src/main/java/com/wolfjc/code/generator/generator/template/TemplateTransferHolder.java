package com.wolfjc.code.generator.generator.template;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.table.TableInfo;

public class TemplateTransferHolder implements Filler {

    private Filler nextFiller;

    public TemplateTransferHolder(Config config) {
        this.nextFiller = new EntityTemplateTransfer(config
                , new DaoTemplateTransfer(config
                , new ServiceTemplateTransfer(config
                , new ServiceImplTemplateTransfer(config
                , null))));
    }

    @Override
    public void fill(TemplateInfo templateInfo, TableInfo tableInfo) {
        if (nextFiller != null) {
            nextFiller.fill(templateInfo, tableInfo);
        }
    }
}
