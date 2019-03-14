package com.wolfjc.code.generator.generator;


import com.wolfjc.code.generator.config.Config;
import com.wolfjc.code.generator.config.TemplateConfig;
import com.wolfjc.code.generator.constant.Constant;
import com.wolfjc.code.generator.constant.EnumFileType;
import com.wolfjc.code.generator.generator.template.CommonTemplateInfo;
import com.wolfjc.code.generator.generator.template.EntityTemplateInfo;
import com.wolfjc.code.generator.generator.template.TemplateInfo;
import com.wolfjc.code.generator.util.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;

/**
 * FreeMarker文件生成器
 * <p>
 * 使用freemark模板引擎生成目标文件
 *
 * @author wolfjc
 */
public class FreeMarkerGenerateStrategy implements GenerateStrategy {

    /**
     * maven插件日志
     */
    private Log log = new SystemStreamLog();

    /**
     * freemarker配置
     */
    private Configuration cfg;

    /**
     * 模板配置
     */
    private TemplateConfig templateConfig;

    /**
     * 用于出初始化freemarker模板引擎
     */
    public FreeMarkerGenerateStrategy(Config config) {
        this.templateConfig = config.getTemplate();
        this.cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        try {
            cfg.setDirectoryForTemplateLoading(new File(templateConfig.getBaseTemplatePath()));
        } catch (IOException e) {
            log.error("初始化freemarker模板配置失败", e);
            e.printStackTrace();
        }
    }

    @Override
    public void generate(TemplateInfo templateInfo) {
        if (templateInfo == null) {
            return;
        }
        EntityTemplateInfo entityTemplateInfo = templateInfo.getEntityTemplateInfo();
        String targetFile = "";
        if (entityTemplateInfo != null) {
            targetFile = getTargetFilePath(entityTemplateInfo);
            generateFile(entityTemplateInfo, targetFile, TemplateConfig.DEFAULT_ENTITY);
        }
        CommonTemplateInfo serviceTemplateInfo = templateInfo.getServiceTemplateInfo();
        if (serviceTemplateInfo != null) {
            targetFile = getTargetFilePath(serviceTemplateInfo);
            generateFile(serviceTemplateInfo, targetFile, TemplateConfig.DEFAULT_SERVICE);
        }
        CommonTemplateInfo daoTemplateInfo = templateInfo.getDaoTemplateInfo();
        if (daoTemplateInfo != null) {
            targetFile = getTargetFilePath(daoTemplateInfo);
            generateFile(daoTemplateInfo, targetFile, TemplateConfig.DEFAULT_DAO);
        }
        CommonTemplateInfo serviceImplTemplateInfo = templateInfo.getServiceImplTemplateInfo();
        if (serviceImplTemplateInfo != null) {
            targetFile = getTargetFilePath(serviceImplTemplateInfo);
            generateFile(serviceImplTemplateInfo, targetFile, TemplateConfig.DEFAULT_SERVICE_IMPL);
        }
    }

    /**
     * @param templateInfos
     */
    @Override
    public void generate(Collection<TemplateInfo> templateInfos) {
        if (CollectionUtils.isEmpty(templateInfos)) {
            return;
        }
        templateInfos.forEach(templateInfo -> {
            generate(templateInfo);
        });
    }

    /**
     * 生成输出文件路径
     *
     * @param templateInfo
     * @return
     */
    private <T extends CommonTemplateInfo> String getTargetFilePath(T templateInfo) {
        return  Constant.RELATIVE_JAVA_PATH + File.separator +
                FileUtil.convertPathToResource(templateInfo.getPackageName()) +
                File.separator +
                templateInfo.getClassName() + "." +
                EnumFileType.JAVA.getSuffix();
    }




    /**
     * 生成实体文件
     *
     * @param templateInfo
     */
    public <T extends CommonTemplateInfo> void generateFile(T templateInfo, String targetFile,String type) {
        OutputStream outputStream = null;
        Writer out = null;
        try {
            Template temp = cfg.getTemplate(type);
            File file = new File(targetFile);
            outputStream = new FileOutputStream(file);
            out = new OutputStreamWriter(outputStream);
            temp.process(templateInfo, out);
            outputStream.close();
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
