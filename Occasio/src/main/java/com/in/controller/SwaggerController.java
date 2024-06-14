package com.in.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerController {
	@Bean
	public Docket libraryApi() {// Docket is an interface
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Occasio-API") // API Name
				.select().apis(RequestHandlerSelectors.basePackage("com.in.controller")).build();// create
																													// api
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Occasio").termsOfServiceUrl("http://google.co.in")// terms and
																									// conditions of
																									// page link to be
																									// inserted
				.version("1.0")
				.build();
	}
}
