package com.saimuga.abp.fileupload.config;



import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DBConfig {

    
	@Bean
	@Primary
	 public DataSource dataSource() {
		System.out.println("");
		return DataSourceBuilder.create().driverClassName("org.postgresql.Driver").url("jdbc:postgresql://localhost:5432/postgres")
			   .username("postgres").password("root").build();	
	}
}
