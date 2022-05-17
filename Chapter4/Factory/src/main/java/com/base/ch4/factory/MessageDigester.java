package com.base.ch4.factory;

import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest md1;
    private MessageDigest md2;

    public void setMd1(MessageDigest md1) {
        this.md1 = md1;
    }

    public void setMd2(MessageDigest md2) {
        this.md2 = md2;
    }

    public void digest(String msg){
        System.out.println("Using digest one ");
        digest(msg, md1);
        System.out.println("Using digest two ");
        digest(msg, md2);
    }

    public void digest(String msg, MessageDigest messageDigest){
        System.out.println("Using algorithm: " + messageDigest.getAlgorithm());
        messageDigest.reset();

        byte[] bytes = msg.getBytes();
        byte[] out = messageDigest.digest(bytes);

        System.out.println(out);
    }
}
