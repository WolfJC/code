package com.wolfjc.code.generator.template.generate;

import com.wolfjc.code.generator.config.TemplateConfig;
import com.wolfjc.code.generator.template.AttributeTempalteInfo;
import com.wolfjc.code.generator.template.EntityTemplateInfo;
import com.wolfjc.code.generator.template.TemplateInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
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


    public FreeMarkerGenerator() throws Exception{
        this.cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setDirectoryForTemplateLoading(new File(TemplateConfig.DEFAULT_RELATIVE_PATH));
    }

    @Override
    public void generate(TemplateInfo templateInfo) {
        if (templateInfo == null) {
            return;
        }
        EntityTemplateInfo entityTemplateInfo = templateInfo.getEntityTemplateInfo();
        if (entityTemplateInfo != null) {

        }
    }

    /**
     * 生成实体文件
     * @param entityTemplateInfo
     */
    public void generateEntityFile(EntityTemplateInfo entityTemplateInfo) throws Exception{
        Template temp = cfg.getTemplate(TemplateConfig.DEFAULT_ENTITY);
        Writer out = new OutputStreamWriter(System.out);
        temp.process(entityTemplateInfo,out);
    }

    public static void main(String[] args) throws Exception{
        FreeMarkerGenerator freeMarkerGenerator = new FreeMarkerGenerator();

        EntityTemplateInfo entityTemplateInfo = new EntityTemplateInfo();
        entityTemplateInfo.setAuthor("wolfjc");
        entityTemplateInfo.setDateTime("21018-07-14");
        entityTemplateInfo.setClassName("User");
        entityTemplateInfo.setPackageName("com.wolfjc.user");
        entityTemplateInfo.setClassRemarks("用户");
        Collection<AttributeTempalteInfo> attributeTempalteInfos = new ArrayList<>();
        AttributeTempalteInfo attributeTempalteInfo = new AttributeTempalteInfo();
        attributeTempalteInfo.setAttributeName("userName");
        attributeTempalteInfo.setRemarks("用户名");
        attributeTempalteInfo.setDataType("String");

        AttributeTempalteInfo attributeTempalteInfo1 = new AttributeTempalteInfo();
        attributeTempalteInfo1.setDataType("Integer");
        attributeTempalteInfo1.setRemarks("年龄");
        attributeTempalteInfo1.setAttributeName("age");
        attributeTempalteInfos.add(attributeTempalteInfo);
        attributeTempalteInfos.add(attributeTempalteInfo1);
        entityTemplateInfo.setAttributes(attributeTempalteInfos);

        freeMarkerGenerator.generateEntityFile(entityTemplateInfo);

    }
}
