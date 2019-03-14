package com.wolfjc.code.generator.exception;

/**
 * 暂不支持的文件类型
 *
 * @author xdd
 */
public class UnAcceptableFileTypeException extends RuntimeException {


    public UnAcceptableFileTypeException() {
    }

    public UnAcceptableFileTypeException(String message) {
        super(message);
    }

    public UnAcceptableFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
