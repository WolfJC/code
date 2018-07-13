package com.wolfjc.code.generator.parse;

import com.wolfjc.code.generator.config.GlobalConfig;

import java.io.File;
import java.io.InputStream;

/**
 * 解析配置文件
 *
 * @author xdd
 * @date 2018/7/12.
 */
public interface ConfigPhase {

    /**
     * 解析配置文件
     *
     * @param inputStream
     * @return
     */
    GlobalConfig phase(InputStream inputStream);


    GlobalConfig phase(File file);
}
