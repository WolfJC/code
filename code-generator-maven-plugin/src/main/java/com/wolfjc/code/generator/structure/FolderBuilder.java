package com.wolfjc.code.generator.structure;

import com.wolfjc.code.generator.constant.Constant;
import com.wolfjc.code.generator.enums.EnumPackageType;
import com.wolfjc.code.generator.enums.EnumResourceName;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Collection;

/**
 * 项目结构目录生成器
 *
 * @author xdd
 * @date 2018/7/26.
 */
public class FolderBuilder {


    /**
     * 包名分隔符
     */
    public static final String PACKAGE_SEPARATOR = ".";


    /**
     * 文件分隔符
     */
    public static final String FILE_SEPARATOR = File.separator;


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


    /**
     * 创建目录
     *
     * @param pathName
     */
    public void createFileOrDirectory(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 构建项目基本结构
     *
     * @param basePackage
     */
    public void buildStructure(String basePackage) {

        //java
        buildJavaSourceDirectory(basePackage);

        buildResourceDirectory();

    }

    /**
     * 生成java文件目录
     *
     * @param basePackage 基础包名
     */
    public void buildJavaSourceDirectory(String basePackage) {
        Collection<String> allPackage = EnumPackageType.buildAllPackage(basePackage);

        allPackage.forEach(packageName -> {
            String pathName = Constant.RELATIVE_JAVA_PATH + FILE_SEPARATOR +
                    convertPathToResource(packageName);
            createFileOrDirectory(pathName);
        });
    }

    /**
     * 生成静态资源文件目录
     */
    public void buildResourceDirectory() {
        Collection<String> allResourceDirectory = EnumResourceName.buildAllResourceDirectory();

        allResourceDirectory.forEach(name -> {
            String pathName = Constant.DEFAULT_RESOURCE_PATH + FILE_SEPARATOR + name;
            createFileOrDirectory(pathName);
        });
    }

}
