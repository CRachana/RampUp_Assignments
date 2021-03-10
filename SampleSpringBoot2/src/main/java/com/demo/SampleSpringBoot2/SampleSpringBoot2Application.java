package com.demo.SampleSpringBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SampleSpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBoot2Application.class, args);
	}

	}



