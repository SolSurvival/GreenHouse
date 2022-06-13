package com.GH.GH.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.GH.GH.repo")
@EntityScan(basePackages="com.GH.GH.entity")
public class ApplicationConfig {
    
}
