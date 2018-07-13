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
}
