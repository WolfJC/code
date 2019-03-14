package com.wolfjc.code.generator.table;



import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.config.JdbcConfig;
import com.wolfjc.code.generator.config.TableConfig;
import com.wolfjc.code.generator.constant.EnumTableInfo;
import com.wolfjc.code.generator.constant.EnumYesOrNo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MySql表结构处理器
 *
 * 根据配置文件中的表名获取数据库中表的表结构信息
 *
 * @author xdd
 * @date 2018/7/12.
 */
public class MySqlTableHandler implements TableHandler{

    /**
     * 数据库连接
     */
    private Connection connection;


    private Config config;

    /**
     * maven日志
     */
    private Log log = new SystemStreamLog();


    public MySqlTableHandler(Config config) {
        this.config = config;
    }

    @Override
    public TableInfo handle(TableConfig tableConfig) {
        TableInfo tableInfo = null;
        try {
           tableInfo =  getTableInfo(tableConfig);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableInfo;
    }

    /**
     * 根据表生成表结构信息
     *
     */
    public Collection<TableInfo> getTables() {
        TableConfig[] tables = config.getTables();
        if (tables == null || tables.length == 0){
            throw new RuntimeException("未设置表信息");
        }

        initConnection();

        List<TableInfo> tableInfos = Arrays.stream(tables)
                .map(tableConfig -> {
                    TableInfo tableInfo = handle(tableConfig);
                    return tableInfo;
                }).collect(Collectors.toList());

        closeConnection();

        return tableInfos;
    }

    /**
     * 初始化数据库连接
     *
     */
    private void initConnection() {
        log.debug("初始化数据库连接");
        JdbcConfig jdbcConfig = config.getJdbc();
        try {
            Class.forName(jdbcConfig.getDriver());
            connection = DriverManager.getConnection(jdbcConfig.getUrl(),
                    jdbcConfig.getUsername(),
                    jdbcConfig.getPassword());
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

    /**
     * 获取表结构信息
     *
     * @param config
     */
    private TableInfo getTableInfo(TableConfig config) throws SQLException{

        DatabaseMetaData metaData = connection.getMetaData();
        TableInfo tableInfo = new TableInfo();
        String tableName = config.getName();
        tableInfo.setTableName(tableName);
        tableInfo.setEntityName(config.getEntity());

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
