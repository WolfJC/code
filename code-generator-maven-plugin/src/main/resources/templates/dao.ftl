package ${packageName};


import com.wolfjc.common.core.BaseDao;
import org.apache.ibatis.annotations.Mapper;
<#list imports as import>
import ${import}
</#list>

/**
 * ${classRemarks}
 * @author ${author}
 * @date ${dateTime}
 */
@Mapper
public interface ${className}Dao extends BaseDao<${className}> {

}

