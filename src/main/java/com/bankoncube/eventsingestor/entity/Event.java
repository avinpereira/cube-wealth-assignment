package com.bankoncube.eventsingestor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "EVENT")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
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

    @Embedded
    private Property property;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", noun='" + noun + '\'' +
                ", verb='" + verb + '\'' +
                ", sourceTimestamp=" + sourceTimestamp +
                ", latLong='" + latLong + '\'' +
                ", timeSpentOnScreen=" + timeSpentOnScreen +
                ", property=" + property +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
