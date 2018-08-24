package com.wolfjc.code.generator;

import com.wolfjc.code.generator.config.GlobalConfig;
import com.wolfjc.code.generator.db.TableInfo;
import com.wolfjc.code.generator.db.TableInfoHandle;
import com.wolfjc.code.generator.parse.ConfigPhase;
import com.wolfjc.code.generator.parse.PropertiesConfigPhase;
import com.wolfjc.code.generator.structure.FolderBuilder;
import com.wolfjc.code.generator.template.TemplateInfo;
import com.wolfjc.code.generator.template.TemplateInfoTransfer;
import com.wolfjc.code.generator.template.generate.FileGenerate;
import com.wolfjc.code.generator.template.generate.FreeMarkerGenerator;
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


    /**
     * 模板转换器
     * <p>
     * 用来将表结构数据转换成对应的模板数据
     */
    private TemplateInfoTransfer templateInfoTransfer;


    /**
     * 文件生成器
     * <p>
     * 生成目标文件
     */
    private FileGenerate fileGenerate;


    private FolderBuilder folderBuilder;


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

    public void setFileGenerate(FileGenerate fileGenerate) {
        this.fileGenerate = fileGenerate;
    }

    public void setFolderBuilder(FolderBuilder folderBuilder) {
        this.folderBuilder = folderBuilder;
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

        initHandle(globalConfig);

        buildProjectStructure(globalConfig);

        generateCode(globalConfig);

    }

    /**
     * 根据配置初始化各种处理器
     *
     * @param globalConfig
     */
    private void initHandle(GlobalConfig globalConfig) {

        //设置表结构处理器
        this.setTableInfoHandle(new TableInfoHandle());

        //设置
        this.setTemplateInfoTransfer(new TemplateInfoTransfer(globalConfig.getCodeGeneratorOption()));
        //设置文件生成器
        this.setFileGenerate(new FreeMarkerGenerator());
        //项目结构生成器
        this.setFolderBuilder(new FolderBuilder());
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
    protected void buildProjectStructure(GlobalConfig globalConfig) {
        log.info("=======生成项目结构");
        folderBuilder.buildStructure(globalConfig.getCodeGeneratorOption().getBasePackage());
    }


    /**
     * 生成模板代码
     */
    protected void generateCode(GlobalConfig globalConfig) {

        log.info("=======生成模板代码...");

        Collection<TableInfo> tableInfos = tableInfoHandle.handle(globalConfig);

        Collection<TemplateInfo> templateInfos = templateInfoTransfer.transfer(tableInfos);

        fileGenerate.generate(templateInfos);

        log.info("");


    }

    /**
     * @return
     */
    public static CodeGeneratorProcessor newInstance() {
        CodeGeneratorProcessor codeGeneratorProcessor = new CodeGeneratorProcessor();
        //默认使用properties文件
        codeGeneratorProcessor.setConfigPhase(new PropertiesConfigPhase());

        return codeGeneratorProcessor;
    }



    private CodeGeneratorProcessor() {
    }

    public static void main(String[] args) {

        File configPath = new File("C:\\Users\\xudongdong\\Home\\code\\code-generator-example\\src\\main\\resources\\code-generator.properties");

        CodeGeneratorProcessor codeGeneratorProcessor = CodeGeneratorProcessor.newInstance();

        codeGeneratorProcessor.generate(configPath);
    }
}


