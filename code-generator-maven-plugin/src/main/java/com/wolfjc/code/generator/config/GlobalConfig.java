package com.wolfjc.code.generator.config;


/**
 * 全局配置
 * <p>
 * 该实体用来保存从外部获取数据库的配置以及代码生成规则
 *
 * @author xdd
 * @date 2018/7/11.
 */
public class GlobalConfig {

    /**
     * 数据源配置
     */
    private DataSourceConfig dataSourceConfig;

    /**
     * 代码生成选项
     */
    private CodeGeneratorOption codeGeneratorOption;

    /**
     * 模板文件配置
     */
    private TemplateConfig templateConfig;


    public DataSourceConfig getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public CodeGeneratorOption getCodeGeneratorOption() {
        return codeGeneratorOption;
    }

    public void setCodeGeneratorOption(CodeGeneratorOption codeGeneratorOption) {
        this.codeGeneratorOption = codeGeneratorOption;
    }
}
