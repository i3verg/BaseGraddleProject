package com.base.ch4.resourcesdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class ResourceDemo {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        Resource resource1 = context.getResource("file://" + file.getPath());
        displayInfo(resource1);

        Resource resource2 = context.getResource("classpath:text.txt");
        displayInfo(resource2);

        Resource resource3 = context.getResource("https://google.com");
        displayInfo(resource3);


    }

    public static void displayInfo(Resource res) throws IOException {
        System.out.println(res.getClass());
        System.out.println("");
    }
}
