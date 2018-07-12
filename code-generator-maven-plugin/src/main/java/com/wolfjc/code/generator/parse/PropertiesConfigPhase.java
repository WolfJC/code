package com.wolfjc.code.generator.parse;

import com.wolfjc.code.generator.config.DataSourceConfig;
import com.wolfjc.code.generator.config.GlobalConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
     *
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
        if (resourceBundle == null) {
            return null;
        }
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
}
