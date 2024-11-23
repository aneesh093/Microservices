package com.talkytech.cards;

import com.talkytech.cards.dto.CardsContactInfoDTO;
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
@EnableConfigurationProperties(value = {CardsContactInfoDTO.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Cards Microservice REST API Documentation",
				description = " Cards microservice REST API Documentation",
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
				description = " Cards microservice REST API Documentation",
				url="https://www.test.com"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
