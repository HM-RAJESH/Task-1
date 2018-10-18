package com.lunatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LunatechDemo {

	public static void main(String[] args) {
		SpringApplication.run(LunatechDemo.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/api/v1/**")).build()
				.genericModelSubstitutes(ResponseEntity.class);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Demo APIs").build();
	}
}
