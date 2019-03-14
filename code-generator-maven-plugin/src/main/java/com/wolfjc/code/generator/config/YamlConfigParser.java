package com.wolfjc.code.generator.config;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.ho.yaml.Yaml;


import java.io.File;

/**
 * ymal配置文件解析器
 *
 * @author xdd
 */
public class YamlConfigParser implements ConfigParser {

    private Log log = new SystemStreamLog();

    @Override
    public Config parse(File file) {
        Config config = null;
        try {
            config  = Yaml.loadType(file, Config.class);
        }catch (Exception e){
            log.debug(e.getMessage() ,e);
        }
        return config;
    }

}
