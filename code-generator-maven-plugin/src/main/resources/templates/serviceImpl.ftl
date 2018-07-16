package com.wolfjc.user.service.impl;


import com.wolfjc.common.core.AbstractService;
<#list imports as import>
import ${import}
</#list>
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;


/**
 * ${classRemarks}
 *
 * @author ${author}
 * @date ${dateTime}
 */
@Service(timeout = 5000,interfaceName = "${className?uncap_first}Service")
public class ${className}ServiceImpl extends AbstractService<${className}> implements ${className}Service {
    @Resource
    private ${className}Dao ${className}Dao;

}