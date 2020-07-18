package com.bankoncube.eventsingestor;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
public class EventsIngestorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EventsIngestorApplication.class, args);
	}

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public void run(String... args) throws Exception {

		Customer customer1 = new Customer(null, 178766, "Avin Pereira", null);
		Customer customer2 = new Customer(null, 178765, "Stella Pereira", null);
		customerRepository.saveAll(Arrays.asList(customer1, customer2));

	}
}
