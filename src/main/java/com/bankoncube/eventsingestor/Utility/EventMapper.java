package com.bankoncube.eventsingestor.Utility;

import com.bankoncube.eventsingestor.dto.request.NewEventRequestBody;
import com.bankoncube.eventsingestor.dto.request.Properties;
import com.bankoncube.eventsingestor.entity.Customer;
import com.bankoncube.eventsingestor.entity.Event;
import com.bankoncube.eventsingestor.entity.Property;

import java.time.Instant;

public class EventMapper {

    public static Event mapToEventEntity(NewEventRequestBody requestBody, Customer customer){
        return new Event().toBuilder()
                .customer(customer)
                .latLong(requestBody.getLatLong())
                .noun(requestBody.getNoun())
                .property(mapProperty(requestBody.getProperties()))
                .sourceTimestamp(mapInstant(requestBody.getTs()))
                .timeSpentOnScreen(requestBody.getTimeSpent())
                .verb(requestBody.getVerb())
                .build();

    }

    private static Instant mapInstant(String string) {
        CharSequence date = string.subSequence(0, 8);
        date = date.subSequence(0, 4) + "-" + date.subSequence(4,6) + "-" + date.subSequence(6, 8);
        CharSequence time = string.subSequence(9, 15);
        time = time.subSequence(0, 2) + ":" + time.subSequence(2, 4) + ":" +  time.subSequence(4,6);
        return Instant.parse(date + "T" + time + ".00Z");
    }

    private static Property mapProperty(Properties property) {
        return (property != null) ? new Property().toBuilder()
                .bank(property.getBank())
                .merchantId(property.getMerchantId())
                .mode(property.getMode())
                .text(property.getText())
                .value(property.getValue())
                .build() : null;
    }
}
