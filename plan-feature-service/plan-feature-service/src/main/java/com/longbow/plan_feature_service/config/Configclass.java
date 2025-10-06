package com.longbow.plan_feature_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configclass {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
