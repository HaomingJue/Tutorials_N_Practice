package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Jackason", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			repository.save(new Customer("David", "Dessler"));
			repository.save(new Customer("Chloe", "O'Brian"));

			log.info("Customers found with findAll()");
			log.info("----------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}

			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("-----------------------------------");
			log.info(customer.toString());
			log.info("");

			log.info("Customer found with findByLastName('Palmer')");
			log.info("--------------------------------------------");
			repository.findByLastName("Palmer").forEach(palmer -> {
				log.info(palmer.toString());
			});
			log.info("");
		};
	}

}
