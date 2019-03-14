package com.wolfjc.code.generator.generator.template;

import java.util.Collection;

/**
 * 实体的模板信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class EntityTemplateInfo extends CommonTemplateInfo implements TemplateData{

    /**
     * 属性
     */
    private Collection<AttributeTemplateInfo> attributes;



    public Collection<AttributeTemplateInfo> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<AttributeTemplateInfo> attributes) {
        this.attributes = attributes;
    }


}
