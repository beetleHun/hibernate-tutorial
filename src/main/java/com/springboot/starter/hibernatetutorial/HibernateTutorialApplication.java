package com.springboot.starter.hibernatetutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HibernateTutorialApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(HibernateTutorialApplication.class, args);
//		for (String name : run.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
    }
}
