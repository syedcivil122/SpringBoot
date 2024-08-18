package com.tejait.batch12;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class Batch12Application {
	public static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(Batch12Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Batch12Application.class, args);
		Logger.debug("debug method"); // developer logs
		Logger.info("info method");  // user transcation intiated production loga
		Logger.warn("warn method"); // user enter otp below 3 sec, has a chances a filure type transaction
		Logger.error("error method"); // transcation failed error
		Logger.fatal("fatal method");
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

	
}


