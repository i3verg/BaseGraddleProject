package com.base.ch4.destroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBean implements InitializingBean {

    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization section Initialing BEAN");

        if (filePath == null) {
            throw new IllegalArgumentException("You must set path for file.\n This is property of DestructiveBean.class");
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File was created :? " + file.exists());
    }

    public void destroy() {
        System.out.println("Destroying BEAN");

        if (!file.delete()) {
            System.err.println("Error: failed to delete file");
        }

        System.out.println("File was deleted :? " + !file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        System.out.println("Context creation");
        GenericXmlApplicationContext xmlContext = new GenericXmlApplicationContext();
        xmlContext.load("classpath:xml-destroy-app-context.xml");
        xmlContext.refresh();
        System.out.println("CONTEXT REFRESHED");
        DestructiveBean destructiveBean = xmlContext.getBean("destructiveBean", DestructiveBean.class);
        System.out.println("Calling destroy");
        destructiveBean.destroy();
        System.out.println("Called destroy");
    }

}
