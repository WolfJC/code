package com.wolfjc.code.generator.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类注释配置
 */
public class NoteConfig {

    /**
     * 对应@author注解
     */
    private String author;

    /**
     * 类生成日期
     *
     * 默认为当前时间
     */
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
