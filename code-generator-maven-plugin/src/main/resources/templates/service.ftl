package ${packageName};


import com.wolfjc.common.core.Service;
<#list imports as import>
import ${import}
</#list>


/**
 * ${classRemarks}
 *
 * @author ${author}
 * @date ${dateTime}
 */
public interface ${className}Service extends Service<${className}> {

}