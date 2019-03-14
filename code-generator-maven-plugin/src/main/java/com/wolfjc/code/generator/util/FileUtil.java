package com.wolfjc.code.generator.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 *
 * @author xdd
 */
public class FileUtil {

    /**
     * 包名分隔符
     */
    public static final String PACKAGE_SEPARATOR = ".";


    /**
     * 文件分隔符
     */
    public static final String FILE_SEPARATOR = File.separator;

    /**
     * 获取文件后缀名
     */
    public static String getFileSuffix(String fileName){

        return StringUtils.substringAfterLast(fileName, ".");
    }


    /**
     * 替换包名中的分隔符为文件分隔符
     *
     * @param packagePath
     * @return
     */
    public static String convertPathToResource(String packagePath) {
        if (StringUtils.isEmpty(packagePath)) {
            throw new NullPointerException("包名不能为空");
        }
        return packagePath.replace(PACKAGE_SEPARATOR, FILE_SEPARATOR);
    }
}
