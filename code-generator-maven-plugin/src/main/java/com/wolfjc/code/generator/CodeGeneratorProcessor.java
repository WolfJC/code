package com.wolfjc.code.generator;

import com.wolfjc.code.generator.config.GlobalConfig;
import com.wolfjc.code.generator.db.TableInfo;
import com.wolfjc.code.generator.db.TableInfoHandle;
import com.wolfjc.code.generator.parse.ConfigPhase;
import com.wolfjc.code.generator.parse.PropertiesConfigPhase;
import com.wolfjc.code.generator.template.TemplateInfo;
import com.wolfjc.code.generator.template.TemplateInfoTransfer;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.io.File;
import java.util.Collection;

/**
 * 代码生成处理类
 *
 * @author xdd
 * @date 2018/7/11.
 */
public class CodeGeneratorProcessor {

    /**
     * 配置文件解析器
     */
    private ConfigPhase configPhase;

    /**
     * 表结构处理器
     */
    private TableInfoHandle tableInfoHandle;


    private TemplateInfoTransfer templateInfoTransfer;


    /**
     * 设置解析器
     *
     * @param configPhase
     */
    public void setConfigPhase(ConfigPhase configPhase) {
        this.configPhase = configPhase;
    }

    /**
     * 设置表结构处理器
     *
     * @param tableInfoHandle
     */
    public void setTableInfoHandle(TableInfoHandle tableInfoHandle) {
        this.tableInfoHandle = tableInfoHandle;
    }


    public void setTemplateInfoTransfer(TemplateInfoTransfer templateInfoTransfer) {
        this.templateInfoTransfer = templateInfoTransfer;
    }

    /**
     * maven 插件日志工具
     */
    private Log log = new SystemStreamLog();

    /**
     * 代码生成
     */
    public void generate(File file) {
        log.info("=======开始生成模板代码========");
        GlobalConfig globalConfig = getAllConfig(file);

        buildProjectStructure();

        generateCode(globalConfig);

    }


    /**
     * 获取配置文件
     *
     * @return
     */
    protected GlobalConfig getAllConfig(File file) {
        log.info("=======获取配置文件");

        GlobalConfig config = this.configPhase.phase(file);

        return config;
    }


    /**
     * 生成项目骨架
     * <p>
     * 1.根据包名生成路径
     */
    protected void buildProjectStructure() {
        log.info("=======生成项目结构");
    }


    /**
     * 生成模板代码
     */
    protected void generateCode(GlobalConfig globalConfig) {
        log.info("=======生成模板代码...");

        Collection<TableInfo> tableInfos = tableInfoHandle.handle(globalConfig);

        Collection<TemplateInfo> templateInfos = templateInfoTransfer.transfer(tableInfos);


        log.info("");


    }

    /**
     *
     * @return
     */
    public static CodeGeneratorProcessor newInstance() {
        CodeGeneratorProcessor codeGeneratorProcessor = new CodeGeneratorProcessor();
        //默认使用properties文件
        codeGeneratorProcessor.setConfigPhase(new PropertiesConfigPhase());

        codeGeneratorProcessor.setTableInfoHandle(new TableInfoHandle());

        //todo::选择模板转换器
//        codeGeneratorProcessor.setTemplateInfoTransfer(new TemplateInfoTransfer());

        return codeGeneratorProcessor;
    }

    private CodeGeneratorProcessor() {
    }
}
