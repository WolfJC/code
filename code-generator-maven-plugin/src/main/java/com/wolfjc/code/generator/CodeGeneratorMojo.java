package com.wolfjc.code.generator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 *
 * @author xdd
 * @date 2018/7/10.
 */
@Mojo(name = "generator")
public class CodeGeneratorMojo extends AbstractMojo {

    /**
     * 外部配置文件的路径
     */
    @Parameter(defaultValue = "${basedir}/src/main/resources/code-generator.properties")
    private File configPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        CodeGeneratorProcessor codeGeneratorProcessor = CodeGeneratorProcessor.newInstance();

        codeGeneratorProcessor.generate(configPath);

    }
}
