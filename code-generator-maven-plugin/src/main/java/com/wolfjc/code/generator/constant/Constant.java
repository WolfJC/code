package com.wolfjc.code.generator.constant;

import java.io.File;

/**
 * @author xdd
 * @date 2018/8/24.
 */
public class Constant {

    /**
     * java源文件路径
     */
    public static final String DEFAULT_JAVA_PATH = "src" + File.separator + "main" + File.separator + "java";

    /**
     * 静态资源文件路径
     */
    public static final String DEFAULT_RESOURCE_PATH = "src" + File.separator + "main" + File.separator + "resources";


    /**
     * maven工程java源文件相对路径
     */
    public static final String RELATIVE_JAVA_PATH = "." + File.separator + DEFAULT_JAVA_PATH;


    /**
     * maven工程静态资源文件相对路径
     */
    public static final String RELATIVE_RESOURCE_PATH = "." + File.separator + DEFAULT_RESOURCE_PATH;
}
