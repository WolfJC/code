package com.wolfjc.code.generator.db;

import com.wolfjc.code.generator.config.CodeGeneratorOption;
import com.wolfjc.code.generator.config.DataSourceConfig;
import com.wolfjc.code.generator.config.GlobalConfig;
import com.wolfjc.code.generator.config.TableConfig;
import com.wolfjc.code.generator.enums.EnumTableInfo;
import com.wolfjc.code.generator.enums.EnumTableStructure;
import com.wolfjc.code.generator.enums.EnumYesOrNo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 表结构处理器
 *
 * 根据配置文件中的表名获取数据库中表的表结构信息
 *
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
     * 根据表生成表结构信息
     *
     * @param globalConfig 配置文件
     */
    public Collection<TableInfo> handle(GlobalConfig globalConfig) {

        DataSourceConfig dataSourceConfig = globalConfig.getDataSourceConfig();

        CodeGeneratorOption codeGeneratorOption = globalConfig.getCodeGeneratorOption();

        initConnection(dataSourceConfig);

        Collection<TableInfo> tableInfos = getTableInfos(codeGeneratorOption.getTableConfigs());

        closeConnection();

        return tableInfos;
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
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.error("关闭数据库连接失败", e);
        }

    }

    private Collection<TableInfo> getTableInfos(Collection<TableConfig> configs){
        return configs.stream()
                .map(config->{
                    TableInfo tableInfo = null;
                    try {
                         tableInfo = getTableInfo(config);
                    }catch (SQLException e){
                        log.error("获取表结构信息失败",e);
                    }
                    return tableInfo;
                }).collect(Collectors.toList());
    }


    /**
     * 获取表结构信息
     *
     * @param config
     */
    private TableInfo getTableInfo(TableConfig config) throws SQLException {
        if (config == null) {
            return null;
        }
        DatabaseMetaData metaData = connection.getMetaData();

        TableInfo tableInfo = new TableInfo();

        String tableName = config.getTableName();

        tableInfo.setTableName(config.getTableName());

        tableInfo.setEntityName(config.getEntityName());

        ResultSet resultSet = metaData.getTables(null, "%", tableName, new String[]{"TABLE"});

        if (resultSet.next()) {
            String remarks = resultSet.getString(EnumTableInfo.REMARKS.getName());
            tableInfo.setRemarks(remarks);
        }

        Collection<ColumnInfo> columnInfos = getColumInfos(metaData, tableName);

        tableInfo.setColumnInfos(columnInfos);

        return tableInfo;

    }

    /**
     * 获取列信息
     *
     * @param metaData
     * @param tableName
     * @return
     * @throws SQLException
     */
    private Collection<ColumnInfo> getColumInfos(DatabaseMetaData metaData, String tableName) throws SQLException {
        Collection<ColumnInfo> columnInfos = new ArrayList<>();

        ResultSet resultSet = metaData.getColumns(null, "%", tableName, "%");

        while (resultSet.next()) {
            ColumnInfo columnInfo = new ColumnInfo();
            String columnName = resultSet.getString(EnumTableStructure.COLUMN_NAME.getName());
            columnInfo.setColumnName(columnName);
            String dataType = resultSet.getString(EnumTableStructure.DATA_TYPE.getName());
            columnInfo.setDataType(dataType);
            String remarks = resultSet.getString(EnumTableStructure.REMARKS.getName());
            columnInfo.setRemarks(remarks);
            String autoIncrementStr = resultSet.getString(EnumTableStructure.IS_AUTOINCREMENT.getName());
            columnInfo.setAutoincrement(EnumYesOrNo.YES.getName().equals(autoIncrementStr));
            columnInfos.add(columnInfo);
        }

        return columnInfos;
    }


}
