package org.duttydev.ssdrapi.samplespringdatarestapi;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document
@Data
@Builder
public class Event {
    @Id
    private String id;
    private String name;
    private String description;
    private Instant startTime;
    private Instant endTime;
    private List<String> guesEmails;
}
