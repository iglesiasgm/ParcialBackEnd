package com.example.ParcialIglesiasBackEnd;

import entities.Mutant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.MutantRepository;
import services.MutantService;



@EntityScan(basePackages = "Entities")
@ComponentScan(basePackages = {"Services", "Repositories", "Entities"})
@SpringBootApplication  //(scanBasePackages = {"com.example.ParcialIglesiasBackEnd", "services", "repositories"})
@EnableJpaRepositories(basePackages = {"repositories"})
public class ParcialIglesiasBackEndApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(ParcialIglesiasBackEndApplication.class, args);

		System.out.println("Aplicacion funcionando...");

		// Declarar el ADN de ejemplo
		String[] dnaSequence = {"AAAA", "TTTT", "GGGG", "CCCC"};

		// Obtener el servicio MutantService del contexto de Spring
		MutantService mutantService = context.getBean(MutantService.class);
		MutantRepository mutantRepository = context.getBean(MutantRepository.class);

		// Verificar si es mutante
		boolean isMutant = mutantService.isMutant(dnaSequence);

		// Crear un objeto Mutant
		Mutant mutant = new Mutant();
		mutant.setDna(dnaSequence);
		mutant.setMutant(isMutant);

		// Guardar el objeto Mutant en la base de datos
		mutantRepository.save(mutant);

		if (isMutant) {
			System.out.println("Secuencia de ADN mutante guardada en la base de datos.");
		} else {
			System.out.println("Secuencia de ADN no mutante guardada en la base de datos.");
		}

	}
}


