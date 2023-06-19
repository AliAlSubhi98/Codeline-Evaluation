package com.alialsubhi.Codeline.Evaluation.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventCreationRequest {
    private String name;
    private LocalDate date;
    private String location;
    private int ticketsAvailable;

}
