package com.wolfjc.code.generator.processor;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.generator.CodeGenerator;
import com.wolfjc.code.generator.structure.StructureBuilder;
import com.wolfjc.code.generator.table.TableHandler;
import com.wolfjc.code.generator.table.TableInfo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.util.Collection;

public abstract class AbstractGenerateProcessor implements GeneratorProcessor {

    private Log log = new SystemStreamLog();

    protected Config config;

    /**
     * 项目基本骨架生成器
     */
    private StructureBuilder structureBuilder;

    /**
     * 数据库表信息处理器
     */
    private TableHandler tableHandler;

    /**
     * 代码生成器
     */
    private CodeGenerator codeGenerator;

    public AbstractGenerateProcessor(Config config) {
        this.config = config;
    }

    @Override
    public void process(){
        //初始化配置
        init();
        //构建项目基本骨架
        buildProjectStructure();
        //获取db中表的详情
        Collection<TableInfo> tableInfos = fetchDBTables();
        //生成模板代码
        generateTemplateCode(tableInfos);

    }

    private void init(){
        log.debug("初始化处理器");
        this.structureBuilder = getStructureBuilder();
        this.tableHandler = getTableHandler();
        this.codeGenerator = getCodeGenerator();
    }


    private void buildProjectStructure(){
        log.debug("生成项目骨架");
        structureBuilder.buildProjectStructure();
        log.debug("生成项目骨架...完成");
    }

    private void generateTemplateCode(Collection<TableInfo> tableInfoList){
        log.debug("生成模板代码");
         codeGenerator.generateCode(tableInfoList);
    }


    private Collection<TableInfo> fetchDBTables(){
        return tableHandler.getTables();
    }


    /**
     * 自定义StructureBuilder
     * @return
     */
    protected StructureBuilder getStructureBuilder(){

        return null;
    }

    /**
     * 自定义TableHandler
     */
    protected TableHandler getTableHandler(){

        return null;
    }


    /**
     * 自定义代码生成器
     */
    protected CodeGenerator getCodeGenerator(){

        return  null;
    }


}
