package com.wolfjc.code.generator.db;

import com.wolfjc.code.generator.config.DataSourceConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xdd
 * @date 2018/7/12.
 */
public class TableInfoHandle {

    /**
     * 数据库连接
     */
    private Connection connection;

    /**
     * maven日志
     */
    private Log log = new SystemStreamLog();

    /**
     * 结果集
     */
    private ResultSet resultSet;


    /**
     * 根据表生成表结构信息
     *
     * @param dataSourceConfig 数据库配置
     */
    public void handle(DataSourceConfig dataSourceConfig) {

        initConnection(dataSourceConfig);


        closeConnection();
    }

    /**
     * 初始化数据库连接
     *
     * @param dataSourceConfig
     */
    private void initConnection(DataSourceConfig dataSourceConfig) {
        log.debug("初始化数据库连接");
        try {
            Class.forName(dataSourceConfig.getDriverClassName());
            connection = DriverManager.getConnection(dataSourceConfig.getUrl(),
                    dataSourceConfig.getUsername(),
                    dataSourceConfig.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     */
    private void closeConnection() {
        log.debug("关闭数据库连接");
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取表结构信息
     *
     * @param tableName
     */
    private void getTableInfo(String tableName) throws SQLException {
        if (StringUtils.isEmpty(tableName)) {
            return;
        }
        DatabaseMetaData metaData = connection.getMetaData();

        resultSet = metaData.getColumns(null, "%", tableName, "%");

        while (resultSet.next()){



        }


    }


}
