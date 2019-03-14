package com.wolfjc.code.generator;

import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.config.ConfigParser;
import com.wolfjc.code.generator.config.ConfigParserFactory;
import com.wolfjc.code.generator.processor.DefaultGenerateProcessor;
import com.wolfjc.code.generator.processor.GeneratorProcessor;
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
    @Parameter(name = "configFile",defaultValue = "${basedir}/src/main/resources/code-generator.yml")
    private File configFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        //获取配置文件
        ConfigParser configParser = ConfigParserFactory.getConfigFarser(configFile.getName());
        Config config = configParser.parse(configFile);
        //生成包以及模板代码
        GeneratorProcessor generatorProcessor = new DefaultGenerateProcessor(config);
        generatorProcessor.process();

    }
}
