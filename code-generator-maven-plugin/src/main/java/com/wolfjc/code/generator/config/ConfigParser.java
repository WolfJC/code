package com.wolfjc.code.generator.config;

import java.io.File;

/**
 * 配置文件解析器接口
 *
 * @author xdd
 */
public interface ConfigParser {

    Config parse(File file);
}
