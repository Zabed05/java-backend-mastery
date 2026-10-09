package com.zabed;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // by this annotation we say that this is our configuration class
@ComponentScan("com.zabed") // it scans all the classes which annotated by @Component
public class AppConfig {
}
