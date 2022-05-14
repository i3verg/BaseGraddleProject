package com.base.ch4.contextinforming;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NamedBeanDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:informing-app-context.xml");
        context.refresh();

        NamedBeanExample namedBean = context.getBean("namedExample", NamedBeanExample.class);
        namedBean.sayName();
        context.registerShutdownHook();
    }
}
