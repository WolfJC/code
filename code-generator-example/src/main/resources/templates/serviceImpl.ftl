package ${packageName};


import com.wolfjc.common.core.AbstractService;
<#list imports as import>
import ${import};
</#list>
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;


/**
 * ${classRemarks}
 *
 * @author ${author}
 * @date ${dateTime}
 */
@Service(timeout = 5000,interfaceName = "${entityName?uncap_first}Service")
public class ${entityName}ServiceImpl extends AbstractService<${entityName}> implements ${entityName}Service {
    @Resource
    private ${entityName}Dao ${entityName}Dao;

}