package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.request.NewEventRequestBody;
import com.bankoncube.eventsingestor.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class IngestorController {

    private EventService eventService;

    @Autowired
    public IngestorController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/api/v1/events")
    public ResponseEntity<Void> ingestEvents(@Valid @RequestBody NewEventRequestBody requestBody){
        eventService.ingest(requestBody);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}
