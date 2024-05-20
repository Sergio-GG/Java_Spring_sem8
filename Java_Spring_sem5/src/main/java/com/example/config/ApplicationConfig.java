package com.example.config;

import com.example.aspects.TrackUserAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableAspectJAutoProxy
public class ApplicationConfig {
    @Bean
    public TrackUserAspect aspectTracking(){
        return new TrackUserAspect();
    }
}
