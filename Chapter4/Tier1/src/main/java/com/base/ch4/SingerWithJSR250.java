package com.base.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;


public class SingerWithJSR250 {
    private static final String DEFAULT_NAME = "WellBoy";
    private String signerName;
    private int age = Integer.MIN_VALUE;

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void initPost() {
        System.out.println("Initializing bean");

        if (signerName == null) {
            System.out.println("Using default name");
            signerName = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type Signer.class");
        }
    }

    @Override
    public String toString() {
        return "Signer{" +
                "name='" + signerName + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:post-init-app-context-xml.xml");
        context.refresh();

        getBean("singerOne", context);
        getBean("singerTwo", context);
        getBean("singerThree", context);

        context.close();
    }

    public static SingerWithJSR250 getBean(String beanName, ApplicationContext app) {
        try {
            SingerWithJSR250 bean = (SingerWithJSR250) app.getBean(beanName);
            System.out.println(bean);
            return bean;

        } catch (BeanCreationException bce) {
            System.out.println(bce.getMessage());
        }
        return null;
    }

}
