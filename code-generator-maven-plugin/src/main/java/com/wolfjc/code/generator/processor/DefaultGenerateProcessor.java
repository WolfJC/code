package com.wolfjc.code.generator.processor;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.generator.CodeGenerator;
import com.wolfjc.code.generator.generator.DeFaultCodeGenerator;
import com.wolfjc.code.generator.structure.DefaultStructureBuilder;
import com.wolfjc.code.generator.structure.StructureBuilder;
import com.wolfjc.code.generator.table.MySqlTableHandler;
import com.wolfjc.code.generator.table.TableHandler;

public class DefaultGenerateProcessor extends AbstractGenerateProcessor {

    public DefaultGenerateProcessor(Config config) {
        super(config);
    }

    @Override
    protected StructureBuilder getStructureBuilder() {
        return new DefaultStructureBuilder(config);
    }

    @Override
    protected TableHandler getTableHandler() {
        return new MySqlTableHandler(config);
    }

    @Override
    protected CodeGenerator getCodeGenerator() {
        return new DeFaultCodeGenerator(config);
    }
}
