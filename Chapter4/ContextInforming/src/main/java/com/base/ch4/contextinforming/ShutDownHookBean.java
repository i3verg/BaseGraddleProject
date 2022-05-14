package com.base.ch4.contextinforming;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutDownHookBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if ( applicationContext instanceof GenericApplicationContext){
            System.out.println("SHD was set");
            ((GenericApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}
