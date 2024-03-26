package com.ekart.loginmodule.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
	public GroupedOpenApi groupedOpenApi()
	{
		return GroupedOpenApi.builder().group("ecommerce-application").
		pathsToMatch("com.ekart.loginmodule.controller").build();
	}
	@Bean
	public OpenAPI openApi()
	{
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("E Commerce Application").description(
						"This is a ekart application using springdoc-openapi and OpenAPI 3."));
	}

}
