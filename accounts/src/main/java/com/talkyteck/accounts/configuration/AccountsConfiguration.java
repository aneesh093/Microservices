package com.talkyteck.accounts.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsConfiguration {
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
