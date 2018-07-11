package com.wolfjc.code.generator;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * @author xdd
 * @date 2018/7/10.
 */
public class CodeGeneratorMojo extends AbstractMojo {

    @Parameter(defaultValue = "application.properties")
    private File configPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {


    }
}
