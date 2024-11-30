package com.talkytech.loans;

import com.talkytech.loans.dto.LoansContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDTO.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Loans Microservice REST API Documentation",
				description = "Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name="Tiago Veri",
						email = "tiago@test.com",
						url = "https://www.test.com"
				),
				license = @License(
						name = "Apache 2.0",
						url="https://www.test.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = " Loans microservice REST API Documentation",
				url="https://www.test.com"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
