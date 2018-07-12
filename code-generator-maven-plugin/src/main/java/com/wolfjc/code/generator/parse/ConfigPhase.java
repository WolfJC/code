package com.wolfjc.code.generator.parse;

import java.io.File;
import java.io.InputStream;

/**
 * @author xdd
 * @date 2018/7/12.
 */
public interface ConfigPhase {

    /**
     *
     * @param inputStream
     * @param <T>
     * @return
     */
    <T> T phase(InputStream inputStream);


    <T> T phase(File file);
}
