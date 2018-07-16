package com.wolfjc.code.generator.template;

import java.util.Collection;

/**
 * 实体的模板信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class EntityTemplateInfo  extends CommonTemplateInfo{

    /**
     * 属性
     */
    private Collection<AttributeTempalteInfo> attributes;



    public Collection<AttributeTempalteInfo> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<AttributeTempalteInfo> attributes) {
        this.attributes = attributes;
    }


}
