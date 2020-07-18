package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.request.NewEventRequestBody;
import com.bankoncube.eventsingestor.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class IngestorController {

    private EventService eventService;

    @Autowired
    public IngestorController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/events")
    public void ingestEvents(@Valid @RequestBody NewEventRequestBody requestBody){
        eventService.ingest(requestBody);

    }
}
