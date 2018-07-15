package ${packageName};

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * ${classRemarks}
 *
 * @author ${author}
 * @date ${dateTime}
 */
@Setter
@Getter
public class ${className} implements Serializable {
    <#list attributes as attr>
    /**
     * ${attr.remarks}
     */
    private ${attr.dataType} ${attr.attributeName};
    </#list>
}
