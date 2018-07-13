package com.wolfjc.code.generator.template;

/**
 * 通用的模板信息
 * 比如 作者 时间等信息
 *
 * @author xdd
 * @date 2018/7/13.
 */
public class CommonTemplateInfo {

    /**
     * 作者
     */
    private String author;

    /**
     * 日期
     */
    private String date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
