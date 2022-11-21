package org.softoo.bankapplication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
