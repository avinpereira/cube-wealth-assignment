package com.bankoncube.eventsingestor.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String customerId;
    @OneToMany(mappedBy = "customer")
    private List<Event> events;
}
