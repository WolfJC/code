package com.wolfjc.code.generator.parse;

import com.wolfjc.code.generator.config.CodeGeneratorOption;
import com.wolfjc.code.generator.config.DataSourceConfig;
import com.wolfjc.code.generator.config.GlobalConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * properties配置文件解析
 *
 * @author xdd
 * @date 2018/7/12.
 */
public class PropertiesConfigPhase implements ConfigPhase {

    @Override
    public GlobalConfig phase(InputStream inputStream) {

        GlobalConfig globalConfig = new GlobalConfig();

        ResourceBundle resource = getResource(inputStream);

        DataSourceConfig dataSourceConfig = getDataSourceConfig(resource);
        globalConfig.setDataSourceConfig(dataSourceConfig);

        CodeGeneratorOption codeGenratorOption = getCodeGenratorOption(resource);
        globalConfig.setCodeGeneratorOption(codeGenratorOption);

        return globalConfig;
    }

    @Override
    public GlobalConfig phase(File file) {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return phase(inputStream);
    }

    /**
     * @param inputStream
     * @return
     */
    private ResourceBundle getResource(InputStream inputStream) {
        ResourceBundle resource = null;
        try {
            resource = new PropertyResourceBundle(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resource;
    }

    /**
     * 获取数据源配置
     *
     * @param resourceBundle
     * @return
     */
    private DataSourceConfig getDataSourceConfig(ResourceBundle resourceBundle) {
        Objects.requireNonNull(resourceBundle);
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        String url = resourceBundle.getString(DataSourceConfig.URL);
        String password = resourceBundle.getString(DataSourceConfig.PASSWORD);
        String userName = resourceBundle.getString(DataSourceConfig.USERNAME);
        String className = resourceBundle.getString(DataSourceConfig.DRIVER_CLASS_NAME);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverClassName(className);
        dataSourceConfig.setPassword(password);
        dataSourceConfig.setUsername(userName);
        return dataSourceConfig;
    }

    /**
     * 获取其它配置选项
     *
     * @param resourceBundle
     * @return
     */
    private CodeGeneratorOption getCodeGenratorOption(ResourceBundle resourceBundle) {
        Objects.requireNonNull(resourceBundle);
        CodeGeneratorOption codeGeneratorOption = new CodeGeneratorOption();
        String tableArrays = resourceBundle.getString(CodeGeneratorOption.TABLE_NAME);
        List<String> tableList = Arrays.asList(StringUtils.split(tableArrays, ","));
        codeGeneratorOption.setTableName(tableList);
        String basePackage = resourceBundle.getString(CodeGeneratorOption.BASE_PACKAGE);
        codeGeneratorOption.setBasePackage(basePackage);
        String enrityArrays = resourceBundle.getString(CodeGeneratorOption.ENITTY_NAME);
        List<String> entityList = Arrays.asList(StringUtils.split(enrityArrays));
        codeGeneratorOption.setEntityNames(entityList);
        return codeGeneratorOption;

    }
}
