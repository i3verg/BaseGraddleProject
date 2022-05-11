package com.base.ch4.annotationinit;

import com.base.ch4.Signer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class SingerConfig {

    @Configuration
    static class ConfigSinger {

        @Lazy
        @Bean(initMethod = "init")
        Signer singerOne() {
            Signer singerOne = new Signer();
            singerOne.setSignerName("Victor Tsoi");
            singerOne.setAge(100);
            return singerOne;
        }

        @Lazy
        @Bean(initMethod = "init")
        Signer singerTwo() {
            Signer singerTwo = new Signer();
            singerTwo.setAge(100);
            return singerTwo;
        }

        @Lazy
        @Bean(initMethod = "init")
        Signer singerThree() {
            Signer singerThree = new Signer();
            singerThree.setSignerName("Lindemann");
            return singerThree;
        }

    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(ConfigSinger.class);
        Signer.getBean("singerOne", context);
        Signer.getBean("singerTwo", context);
        Signer.getBean("singerThree", context);
        context.close();
    }

}
