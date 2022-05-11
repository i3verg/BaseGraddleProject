package com.base.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithInterface implements InitializingBean {
    private static final String DEFAULT_NAME = "WellBoy";
    private String signerName;
    private int age = Integer.MIN_VALUE;

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingerWithInterface{" +
                "signerName='" + signerName + '\'' +
                ", age=" + age +
                '}';
    }

    public void afterPropertiesSet(){
        System.out.println("Initializing bean");
        if (signerName == null){
            System.out.println("Using default name");
            signerName=DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type Signer.class");
        }
    }

    public static SingerWithInterface getBean(String beanName, ApplicationContext app) {
        try {
            SingerWithInterface bean = (SingerWithInterface) app.getBean(beanName);
            System.out.println(bean);
            return bean;

        } catch (BeanCreationException bce) {
            System.out.println(bce.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:initializing-bean-context.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();


    }

}
