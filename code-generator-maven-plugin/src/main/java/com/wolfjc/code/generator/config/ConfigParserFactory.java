package com.wolfjc.code.generator.config;


import com.wolfjc.code.generator.enums.EnumFileType;
import com.wolfjc.code.generator.exception.UnAcceptableFileTypeException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

/**
 * @author xdd
 */
public class ConfigParserFactory {

    private Log log = new SystemStreamLog();

    public static  ConfigParser getConfigFarser(String fileName){
        EnumFileType fileType = EnumFileType.getFileType(fileName);
        if (EnumFileType.YAML == fileType){
            return new YamlConfigParser();
        }else if (EnumFileType.PROPERTIES == fileType){
            return null;
        }else {
            throw new UnAcceptableFileTypeException("暂不支持的文件类型:"+fileName);
        }
    }
}
