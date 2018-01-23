package com.lxf.bp.mail.config;

public class MailEnvConfig {
    private String formName;


    @Override
    public String toString() {
        return "MailEnvConfig{" +
                "formName='" + formName + '\'' +
                '}';
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }
}
