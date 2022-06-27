package za.co.casino.casinoassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.casino"})
@EnableJpaRepositories(basePackages = {"za.co.casino.persistence.repository"})
@EntityScan(basePackages = {"za.co.casino"})
public class CasinoAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasinoAssessmentApplication.class, args);
	}

}
