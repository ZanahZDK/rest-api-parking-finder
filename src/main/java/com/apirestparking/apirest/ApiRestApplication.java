package com.apirestparking.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurer() {
        	@Override
        	public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("/**")
    				.allowedOrigins("https://admin-view-parking-finder.netlify.app",
					"https://parkingfinderpaneladmin.com.es")
					
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.allowedHeaders("Content-Type", "Authorization", "X-Requested-With", "Accept", "Origin")
					.allowCredentials(true);
        	}
    	};
	}

}
