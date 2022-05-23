package com.base.ch4.profiling.configurations;

import com.base.ch4.profiling.FoodProviderService;
import com.base.ch4.profiling.vegan.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("vegan")
public class VeganConfig {

    @Bean(name = "foodProviderService")
    public FoodProviderService foodProviderService() {
        return new FoodProviderServiceImpl();
    }
}
