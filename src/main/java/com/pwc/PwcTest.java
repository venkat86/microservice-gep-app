package com.pwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"geppetto.module.bootsecurity.*","com.pwc.*"})
@SpringBootApplication
@EnableDiscoveryClient
public class PwcTest extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PwcTest.class);
    }

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "pwctest-server");
		SpringApplication.run(PwcTest.class, args);
	}
}
