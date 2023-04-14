package com.locacao.gerencia;

import org.springframework.beans.factory.annotation.Autowired;
import 	org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableOpenApi
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
