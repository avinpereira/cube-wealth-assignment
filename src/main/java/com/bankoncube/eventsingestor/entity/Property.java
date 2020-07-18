package com.bankoncube.eventsingestor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Property {

    private String bank;
    private Integer merchantId;
    private Float value;
    private String mode;
    private String text;
}
