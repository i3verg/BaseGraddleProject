package com.base.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Signer {
    private static final String DEFAULT_NAME = "WellBoy";
    private String signerName;
    private int age = Integer.MIN_VALUE;

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
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
        context.load("classpath:init-default-app-context-xml.xml");
        context.refresh();

        getBean("signerOne", context);
        getBean("signerTwo", context);
        getBean("signerThree", context);

        context.close();
    }

    public static Signer getBean(String beanName, ApplicationContext app) {
        try {
            Signer bean = (Signer) app.getBean(beanName);
            System.out.println(bean);
            return bean;

        } catch (BeanCreationException bce) {
            System.out.println(bce.getMessage());
        }
        return null;
    }
}
