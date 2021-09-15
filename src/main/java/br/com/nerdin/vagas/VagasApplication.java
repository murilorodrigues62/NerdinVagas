package br.com.nerdin.vagas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VagasApplication {
	private static final Logger LOGGER = LogManager.getLogger(VagasApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(VagasApplication.class, args);
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(
	) {
		return (evt) -> {
			LOGGER.info("Nerdin API started: http://localhost:8080/");
		};
	}

}
