package com.bankoncube.eventsingestor.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bank",
        "merchantid",
        "value",
        "mode"
})
@Data
public class Properties {

    @JsonProperty("bank")
    private String bank;
    @JsonProperty("merchantid")
    private Integer merchantId;
    @JsonProperty("value")
    private Float value;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("text")
    private String text;

}