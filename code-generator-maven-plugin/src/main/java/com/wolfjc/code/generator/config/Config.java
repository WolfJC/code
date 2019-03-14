package com.wolfjc.code.generator.config;

/**
 * 文件配置
 *
 * @author xdd
 */
public class Config {

    /**
     * jdbc配置
     */
    private JdbcConfig jdbc;

    /**
     * 包名
     */
    private String basePackage;

    /**
     * 注释配置
     */
    private NoteConfig note;


    private TableConfig[] tables;


    private TemplateConfig template = new TemplateConfig();

    public JdbcConfig getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcConfig jdbc) {
        this.jdbc = jdbc;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public NoteConfig getNote() {
        return note;
    }

    public void setNote(NoteConfig note) {
        this.note = note;
    }

    public TableConfig[] getTables() {
        return tables;
    }

    public void setTables(TableConfig[] tables) {
        this.tables = tables;
    }

    public TemplateConfig getTemplate() {
        return template;
    }

    public void setTemplate(TemplateConfig template) {
        this.template = template;
    }
}
