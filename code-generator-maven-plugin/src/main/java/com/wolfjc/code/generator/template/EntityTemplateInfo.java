package com.wolfjc.code.generator.template;

import java.util.Collection;

/**
 * 实体的模板信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class EntityTemplateInfo {

    /**
     * 包名
     */
    private String packageName;

    /**
     * 类名
     */
    private String className;

    /**
     * 作者
     */
    private String author;

    /**
     * 类备注
     */
    private String classRemarks;

    /**
     * 时间
     */
    private String dateTime;

    /**
     * 属性
     */
    private Collection<AttributeTempalteInfo> attributes;

    /**
     * 需要导入的包名
     */
    private Collection<String> imports;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Collection<AttributeTempalteInfo> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<AttributeTempalteInfo> attributes) {
        this.attributes = attributes;
    }

    public Collection<String> getImports() {
        return imports;
    }

    public void setImports(Collection<String> imports) {
        this.imports = imports;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getClassRemarks() {
        return classRemarks;
    }

    public void setClassRemarks(String classRemarks) {
        this.classRemarks = classRemarks;
    }
}
