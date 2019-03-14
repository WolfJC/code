package com.wolfjc.code.generator.structure;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.constant.Constant;
import com.wolfjc.code.generator.constant.EnumPackageType;
import com.wolfjc.code.generator.constant.EnumResourceName;
import com.wolfjc.code.generator.util.FileUtil;

import java.io.File;
import java.util.Collection;

public class DefaultStructureBuilder extends AbstractStructureBuilder {


    public DefaultStructureBuilder(Config config) {
        super(config);
    }

    @Override
    protected void buildJavaSourceDirectory() {
        Collection<String> allPackage = EnumPackageType.buildAllPackage(config.getBasePackage());

        allPackage.forEach(packageName -> {
            String pathName = Constant.RELATIVE_JAVA_PATH + File.separator +
                    FileUtil.convertPathToResource(packageName);
            createFileOrDirectory(pathName);
        });
    }

    @Override
    protected void buildResourceDirectory() {
        Collection<String> allResourceDirectory = EnumResourceName.buildAllResourceDirectory();

        allResourceDirectory.forEach(name -> {
            String pathName = Constant.DEFAULT_RESOURCE_PATH +File.separator + name;
            createFileOrDirectory(pathName);
        });
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
}
