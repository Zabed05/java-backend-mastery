package com.zabed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // by this annotation we say that this is our configuration class
@ComponentScan("com.zabed") // it scans all the classes which annotated by @Component
public class AppConfig {

    @Bean // it tells spring framework that when you read the rules of AppConfig just call that objects methods and stores in the ioc container
    public User createUser(){
        return new User("Zabed", 21);
    }
}
