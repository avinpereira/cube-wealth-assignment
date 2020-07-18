package com.bankoncube.eventsingestor.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.validation.constraints.NotNull;

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

    @NotNull
    @JsonProperty("noun")
    private String noun;

    @NotNull
    @JsonProperty("userid")
    private Integer userId;

    @NotNull
    @JsonProperty("ts")
    private String ts;

    @JsonProperty("latlong")
    private String latLong;

    @NotNull
    @JsonProperty("verb")
    private String verb;

    @JsonProperty("timespent")
    private Integer timeSpent;

    @JsonProperty("properties")
    private Properties properties;

}
