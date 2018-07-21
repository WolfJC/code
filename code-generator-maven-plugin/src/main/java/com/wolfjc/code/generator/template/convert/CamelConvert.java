package com.wolfjc.code.generator.template.convert;

/**
 * 下划线转化为驼峰命名
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class CamelConvert implements Convert {


    @Override
    public String convert(String columnName) {
        if (columnName.indexOf("_") < 0) {
            //不存在下划线，可能是驼峰格式，不处理
            return columnName;
        }
        
        String[] strings = columnName.split("_");

        if (strings == null || strings.length == 0) {
            return columnName;
        }

        StringBuilder sb = new StringBuilder();

        String first = strings[0].toLowerCase();
        sb.append(first);

        for (int i = 1; i < strings.length; i++) {
            String s = strings[i];
            Character c = s.charAt(0);
            String upperS = c.toString().toUpperCase();
            sb.append(upperS);
            sb.append(s.substring(1, s.length()));
        }
        return sb.toString();
    }


}
