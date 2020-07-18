package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.request.NewEventRequestBody;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import com.bankoncube.eventsingestor.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class IngestorController {

    private EventService eventService;
    @Autowired
    private List<Rule> list;

    @Autowired
    public IngestorController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/events")
    public ResponseEntity<Void> ingestEvents(@Valid @RequestBody NewEventRequestBody requestBody){
        System.out.println(list);
        eventService.ingest(requestBody);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
