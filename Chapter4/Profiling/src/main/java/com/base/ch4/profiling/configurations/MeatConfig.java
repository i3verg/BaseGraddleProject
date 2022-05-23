package com.base.ch4.profiling.configurations;

import com.base.ch4.profiling.FoodProviderService;
import com.base.ch4.profiling.meat.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("meat")
public class MeatConfig {

    @Bean
    public FoodProviderService foodProviderService() {
        return new FoodProviderServiceImpl();
    }
}
