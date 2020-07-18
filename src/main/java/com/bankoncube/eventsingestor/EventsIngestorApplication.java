package com.bankoncube.eventsingestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EventsIngestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsIngestorApplication.class, args);
	}

}
