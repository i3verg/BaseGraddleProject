package com.base.ch4.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class MessageDigesterConfigDemo {

    @Configuration
    static class MessageDigesterConfig {
        @Bean
        MessageDigestFactoryBean shaDigest() {
            MessageDigestFactoryBean messageDigestFactoryBean = new MessageDigestFactoryBean();
            messageDigestFactoryBean.setDefaultAlgo("SHA1");
            return messageDigestFactoryBean;
        }

        @Bean
        MessageDigestFactoryBean defaultDigest() {
            return new MessageDigestFactoryBean();
        }

        @Bean
        MessageDigester digester() throws Exception {
            MessageDigester messageDigester = new MessageDigester();
            messageDigester.setMd1(shaDigest().getObject());
            messageDigester.setMd2(defaultDigest().getObject());
            return messageDigester;
        }

    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(MessageDigesterConfig.class);
        MessageDigester messageDigester = (MessageDigester) context.getBean("digester");
        messageDigester.digest("Hi!!!!!!!!");
        context.close();
    }
}
