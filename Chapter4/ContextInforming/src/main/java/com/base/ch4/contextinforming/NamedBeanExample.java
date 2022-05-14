package com.base.ch4.contextinforming;

import org.springframework.beans.factory.BeanNameAware;

public class NamedBeanExample implements BeanNameAware {

    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void sayName() {
        System.out.println("Bean " + beanName + " sayName()");
    }

}
