package com.wolfjc.code.generator.config;

/**
 *
 * 数据源配置
 *
 * @author xdd
 * @date 2018/7/11.
 */
public class DataSourceConfig {


    public static final String URL = "datasource.url";

    public static final String USERNAME = "datasource.username";

    public static final String PASSWORD = "datasource.password";

    public static final String DRIVER_CLASS_NAME = "datasource.driver-class-name";

    /**
     * 数据源连接
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 类名
     */
    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
