package com.bankoncube.eventsingestor.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "EVENT")
@Data
public class Event {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String noun;
    private String verb;
    private Instant sourceTimestamp;
    private String latLong;
    private Integer timeSpentOnScreen;


    @OneToOne
//    @Embedded
    private Property property;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
