package com.wolfjc.code.generator.db;

import com.wolfjc.code.generator.enums.EnumDbType;
import com.wolfjc.code.generator.enums.EnumJavaType;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据类型映射
 * <p>
 * 保存了数据库表字段的数据类型与java包装类型的映射
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class DataTypeMapper {

    private static Map<String, EnumJavaType> map = new HashMap<>();

    private Log log = new SystemStreamLog();

    static {
        map.put(EnumDbType.BIGINT.getType(), EnumJavaType.LONG);
        map.put(EnumDbType.BIT.getType(), EnumJavaType.BOOLEAN);
        map.put(EnumDbType.CHAR.getType(), EnumJavaType.STRING);
        map.put(EnumDbType.DATETIME.getType(), EnumJavaType.DATE);
        map.put(EnumDbType.DECIMAL.getType(), EnumJavaType.DOUBLE);
        map.put(EnumDbType.CHAR.getType(), EnumJavaType.STRING);
        map.put(EnumDbType.FLOAT.getType(), EnumJavaType.FLOAT);
        map.put(EnumDbType.DOUBLE.getType(), EnumJavaType.DOUBLE);
        map.put(EnumDbType.SMALLINT.getType(),EnumJavaType.INTEGER);
        map.put(EnumDbType.INT.getType(), EnumJavaType.INTEGER);
        map.put(EnumDbType.INTEGER.getType(), EnumJavaType.INTEGER);
        map.put(EnumDbType.MEDIUMINT.getType(), EnumJavaType.INTEGER);
        map.put(EnumDbType.TIMESTAMP.getType(), EnumJavaType.DATE);
        map.put(EnumDbType.TEXT.getType(), EnumJavaType.STRING);
        map.put(EnumDbType.VARCHAR.getType(), EnumJavaType.STRING);
        //其余类型都默认对应String

    }

    /**
     * 根据数据库表字段类型查找对应的java数据类型
     *
     * @param sqlType 数据库的数据类型
     * @return
     */
    public static EnumJavaType findDataType(String sqlType) {
        if (StringUtils.isEmpty(sqlType)) {
            return EnumJavaType.STRING;
        }
        String upper = sqlType.toUpperCase();

        EnumJavaType javaType = map.get(upper);

        return javaType;
    }
}
