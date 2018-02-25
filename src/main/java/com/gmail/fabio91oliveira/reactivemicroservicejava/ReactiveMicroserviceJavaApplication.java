package com.gmail.fabio91oliveira.reactivemicroservicejava;

import com.gmail.fabio91oliveira.reactivemicroservicejava.model.Person;
import com.gmail.fabio91oliveira.reactivemicroservicejava.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveMicroserviceJavaApplication {

	@Bean
	CommandLineRunner addPersons(PersonService personService) {
		return args -> {
			personService
					.deleteAll()
					.subscribe(null, null, () -> {
						Stream.of(new Person(UUID.randomUUID().toString(), "Peter"),
								new Person(UUID.randomUUID().toString(), "Sharon"),
								new Person(UUID.randomUUID().toString(), "Jack"),
								new Person(UUID.randomUUID().toString(), "Max"))
								.forEach(person -> personService.save(person).subscribe(System.out::println));
					});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMicroserviceJavaApplication.class, args);
	}
}
