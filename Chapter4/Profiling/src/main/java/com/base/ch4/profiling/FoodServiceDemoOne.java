package com.base.ch4.profiling;

import com.base.ch4.profiling.configurations.VeganConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class FoodServiceDemoOne {
    public static void main(String[] args) {

        GenericApplicationContext context = new AnnotationConfigApplicationContext(VeganConfig.class);
        context.getEnvironment().setActiveProfiles("vegan");
        FoodProviderService foodProviderService = context.getBean("foodProviderService", FoodProviderService.class);



    }
}
