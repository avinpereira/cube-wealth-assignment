package com.bankoncube.eventsingestor.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noun",
        "userid",
        "ts",
        "latlong",
        "verb",
        "timespent",
        "properties"
})
@Data
public class NewEventRequestBody {

    @JsonProperty("noun")
    private String noun;
    @JsonProperty("userid")
    private Integer userId;
    @JsonProperty("ts")
    private String ts;
    @JsonProperty("latlong")
    private String latLong;
    @JsonProperty("verb")
    private String verb;
    @JsonProperty("timespent")
    private Integer timeSpent;
    @JsonProperty("properties")
    private Properties properties;

}
