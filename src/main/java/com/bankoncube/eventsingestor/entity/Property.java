package com.bankoncube.eventsingestor.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "PROPERTY")
@Table(name = "PROPERTY")
@Data
//@Embeddable
public class Property {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String bank;
    private Integer merchantId;
    private Float value;
    private String mode;
    private String text;
}
