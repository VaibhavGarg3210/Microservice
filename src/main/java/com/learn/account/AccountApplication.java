package com.learn.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Account Mircoservice to Perform Crud Operation ", description = "Easy to learn Account operation from scratch by CRUD", version = "1.0", contact = @Contact(name = "Vaibhav Garg", email = "Vaibhavgarg3210@gmail.com", url = "xyz"), license = @License(name = "XYZ", url = "xyz.com")), externalDocs = @ExternalDocumentation(description = "XYZ Bank Account Micro Services"))

public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
