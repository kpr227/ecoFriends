package com.goott.eco.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityIntializer extends AbstractSecurityWebApplicationInitializer{

}
