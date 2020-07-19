package com.bankoncube.eventsingestor.controller;

import com.bankoncube.eventsingestor.dto.request.NewEventRequestBody;
import com.bankoncube.eventsingestor.rule_framework.Rule;
import com.bankoncube.eventsingestor.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    @PostMapping("/rules")
    public ResponseEntity<Void> updateRule(@RequestParam(value="description") String description){
        Optional<Boolean> booleanStream = list.stream().filter(r -> description.equals(r.getDescription())).map(r -> r.isEnabled()).findFirst();
        eventService.ingest(requestBody);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
