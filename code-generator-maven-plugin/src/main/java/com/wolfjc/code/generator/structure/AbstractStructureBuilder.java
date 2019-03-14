package com.wolfjc.code.generator.structure;


import com.wolfjc.code.generator.config.Config;

public class AbstractStructureBuilder implements StructureBuilder {

    protected Config config;

    public AbstractStructureBuilder(Config config) {
        this.config = config;
    }

    @Override
    public void buildProjectStructure() {

        buildJavaSourceDirectory();

        buildResourceDirectory();
    }


    /**
     * 生成java文件目录
     *
     */
    protected void buildJavaSourceDirectory() {

    }

    /**
     * 生成静态资源文件目录
     */
    protected void buildResourceDirectory() {

    }
}
