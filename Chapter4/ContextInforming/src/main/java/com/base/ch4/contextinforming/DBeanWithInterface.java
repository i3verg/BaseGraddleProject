package com.base.ch4.contextinforming;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DBeanWithInterface {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean initializing");

        if (filePath.isEmpty()) {
            throw new IllegalArgumentException("ILEX!!!!!!!!!!!!!!");
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exist " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying bean");

        if (!file.delete()) {
            System.err.println("Error: failed to delete file");
        }
        System.out.println("File exist " + file.exists());
    }

    public void setFilepath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext();
        appCtx.load("classpath:app-context-forsdh.xml");
        //appCtx.registerShutdownHook();
        appCtx.refresh();
        //appCtx.getBean("destructiveBeanTwo", DBeanWithInterface.class);
    }

}
