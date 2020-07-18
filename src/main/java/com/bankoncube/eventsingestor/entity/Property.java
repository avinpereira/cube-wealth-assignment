package com.bankoncube.eventsingestor.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Property {

    private String bank;
    private Integer merchantId;
    private Float value;
    private String mode;
    private String text;
}
