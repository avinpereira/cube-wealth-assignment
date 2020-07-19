package com.bankoncube.eventsingestor.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ResponseElement {
    public String description;
    public String status;

    public ResponseElement(String description, boolean status) {
        this.description = description;
        this.status = status ? "ACTIVE" : "DISABLED";
    }
}
