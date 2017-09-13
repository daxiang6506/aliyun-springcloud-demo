package com.example;

import com.example.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class FooApplication {

	private static final Logger log = LoggerFactory.getLogger(FooApplication.class);
    public static final String KEY = "Database";
    public static final String VALUE = "MySQL";

	public static void main(String[] args) {
		SpringApplication.run(FooApplication.class, args);
	}

    @Bean
	public CommandLineRunner initDatabase(InfoRepository repository){
		return (args) -> {
			repository.save(new Info(KEY,VALUE));
		};
	}
}
