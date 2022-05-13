package com.base.beandestroy;

import com.base.ch4.destroy.DestructiveBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class DestructionBeanConfigExample {

    @Configuration
    static class DestructionBeanConfig {

        @Lazy
        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
        DestructiveBean destructBean() {
            DestructiveBean destructiveBean = new DestructiveBean();
            destructiveBean.setFilePath(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "test.txt");
            return destructiveBean;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DestructionBeanConfig.class);
        ctx.getBean(DestructiveBean.class);
        System.out.println("Calling Destroy");
        ctx.registerShutdownHook();
        System.out.println("Called destroy");
    }


}
