package com.mark.words.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class DocumentationConfig {

	@Bean
	public GroupedOpenApi apiDocumentation() {
		return GroupedOpenApi.builder().group("Words Management").pathsToMatch("/api/**").build();
	}

}
