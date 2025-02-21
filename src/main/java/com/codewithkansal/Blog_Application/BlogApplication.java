package com.codewithkansal.Blog_Application;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info= @Info(
				title = "Spring boot Blog App Rest APIs",
				description = "Spring boot Blog App Rest APIs documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ankit Kansal",
						email = "ankitkansal.dev@gmail.com",
						url = "https://www.linkedin.com/ankit2301"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/ankit2301"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot Blog App Rest APIs documentation",
				url = "https://github.com/ak-2301"
		)
)
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
