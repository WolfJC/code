package com.wolfjc.code.generator.template.generate;

import com.wolfjc.code.generator.config.GlobalConfig;
import com.wolfjc.code.generator.config.TemplateConfig;
import com.wolfjc.code.generator.template.CommonTemplateInfo;
import com.wolfjc.code.generator.template.EntityTemplateInfo;
import com.wolfjc.code.generator.template.TemplateInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;


/**
 * 使用freemark模板引擎生成目标文件
 */
public class FreeMarkerGenerator implements FileGenerate {

    private Log log = new SystemStreamLog();

    /**
     * freemarker配置
     */
    private Configuration cfg;

    private TemplateConfig templateConfig;


    public FreeMarkerGenerator(){
        GlobalConfig globalConfig = GlobalConfig.newInstance();
        templateConfig = globalConfig.getTemplateConfig();
        this.cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        try {
            cfg.setDirectoryForTemplateLoading(new File(templateConfig.getBaseTemplatePath()));
        } catch (IOException e) {
            log.error("初始化freemarker模板配置失败",e);
            e.printStackTrace();
        }
    }

    @Override
    public void generate(TemplateInfo templateInfo) {
        if (templateInfo == null) {
            return;
        }
        EntityTemplateInfo entityTemplateInfo = templateInfo.getEntityTemplateInfo();
        if (entityTemplateInfo != null) {
            generateFile(entityTemplateInfo,TemplateConfig.DEFAULT_ENTITY);
        }
        CommonTemplateInfo serviceTemplateInfo = templateInfo.getServiceTemplateInfo();
        if (serviceTemplateInfo != null){
            generateFile(serviceTemplateInfo,TemplateConfig.DEFAULT_SERVICE);
        }
        CommonTemplateInfo daoTemplateInfo = templateInfo.getDaoTemplateInfo();
        if (daoTemplateInfo != null){
            generateFile(daoTemplateInfo,TemplateConfig.DEFAULT_DAO);
        }
        CommonTemplateInfo serviceImplTemplateInfo = templateInfo.getServiceImplTemplateInfo();
        if (serviceImplTemplateInfo != null){
            generateFile(serviceImplTemplateInfo,TemplateConfig.DEFAULT_SERVICE_IMPL);
        }
    }

    /**
     *
     * @param templateInfos
     */
    @Override
    public void generate(Collection<TemplateInfo> templateInfos) {
        if (CollectionUtils.isEmpty(templateInfos)){
            return;
        }
        templateInfos.forEach(templateInfo -> {
            generate(templateInfo);
        });
    }

    /**
     * 生成实体文件
     * @param entityTemplateInfo
     */
    public <T extends CommonTemplateInfo>void generateFile(T entityTemplateInfo,String type){
        try {
            Template temp = cfg.getTemplate(type);
            Writer out = new OutputStreamWriter(System.out);
            temp.process(entityTemplateInfo,out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateServiceFile(){

    }
}
