package com.wolfjc.code.generator.template;

import java.util.Collection;

/**
 * 通用的模板信息
 * 比如 作者 时间等信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class CommonTemplateInfo {

    /**
     * 作者
     */
    private String author;

    /**
     * 日期
     */
    private String dateTime;


    /**
     * 包名
     */
    private String packageName;

    /**
     * 类备注
     */
    private String classRemarks;


    /**
     * 类名
     */
    private String className;

    /**
     * 需要导入的包名
     */
    private Collection<String> imports;

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassRemarks() {
        return classRemarks;
    }

    public void setClassRemarks(String classRemarks) {
        this.classRemarks = classRemarks;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Collection<String> getImports() {
        return imports;
    }

    public void setImports(Collection<String> imports) {
        this.imports = imports;
    }
}
