package com.bankoncube.eventsingestor;

import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.repository.CustomerRepository;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class EventsIngestorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EventsIngestorApplication.class, args);
	}

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	List<Rule> rules;
	@Override
	public void run(String... args) throws Exception {

		//Two Dummy Users
		Customer customer1 = new Customer(null, 178766, "Avin Pereira", null);
		Customer customer2 = new Customer(null, 178765, "Stella Pereira", null);
		customerRepository.saveAll(Arrays.asList(customer1, customer2));

		//Enabling All Rules at Start Up
		rules.forEach(r -> r.enable(true));
		log.info("Logger is Working");


	}
}
