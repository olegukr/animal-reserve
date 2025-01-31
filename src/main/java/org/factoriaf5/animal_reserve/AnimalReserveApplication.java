package org.factoriaf5.animal_reserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.factoriaf5.animal_reserve.model")
@EnableJpaRepositories(basePackages = "org.factoriaf5.animal_reserve.repository")
public class AnimalReserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalReserveApplication.class, args);
	}

}
