package br.edu.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OxefoodApiMessiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiMessiasApplication.class, args);
	}

}
