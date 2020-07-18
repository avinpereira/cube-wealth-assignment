package com.bankoncube.eventsingestor.service;

import com.bankoncube.eventsingestor.Utility.EventMapper;
import com.bankoncube.eventsingestor.dto.request.NewEventRequestBody;
import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.repository.CustomerRepository;
import com.bankoncube.eventsingestor.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EventService {

    private EventRepository eventRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public EventService(EventRepository eventRepository, CustomerRepository customerRepository) {
        this.eventRepository = eventRepository;
        this.customerRepository = customerRepository;
    }

    public void ingest(NewEventRequestBody requestBody) {
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerId(requestBody.getUserId());
        Customer customer = optionalCustomer.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not Exist"));
        Event event = EventMapper.mapToEventEntity(requestBody, customer);
        eventRepository.saveAndFlush(event);
    }
}
