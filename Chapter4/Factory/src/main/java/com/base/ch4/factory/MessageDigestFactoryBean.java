package com.base.ch4.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

    private String defaultAlgo = "MD5";
    private MessageDigest messageDigest = null;



    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(defaultAlgo);
    }

    public void setDefaultAlgo(String defaultAlgo) {
        this.defaultAlgo = defaultAlgo;
    }

    public boolean isSingleton(){
        return true;
    }
}
