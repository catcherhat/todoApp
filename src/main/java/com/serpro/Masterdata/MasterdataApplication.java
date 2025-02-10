package com.serpro.Masterdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.serpro.Masterdata.repository")
public class MasterdataApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(MasterdataApplication.class, args);
	}

}
