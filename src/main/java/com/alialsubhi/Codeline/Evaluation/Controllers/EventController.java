package com.alialsubhi.Codeline.Evaluation.Controllers;

import com.alialsubhi.Codeline.Evaluation.Models.Event;
import com.alialsubhi.Codeline.Evaluation.Requests.EventCreationRequest;
import com.alialsubhi.Codeline.Evaluation.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    EventService eventService;

    //http://localhost:8080/api/events?location=codeline&dateFrom=2023-06-19&dateTo=2023-06-21&eventName=book
    @GetMapping
    public List<Event> searchEvents(@RequestParam(required = false) String location,
                                    @RequestParam(required = false) LocalDate dateFrom,
                                    @RequestParam(required = false) LocalDate dateTo,
                                    @RequestParam(required = false) String eventName) {
        return eventService.searchEvents(location, dateFrom, dateTo, eventName);
    }


    /*http://localhost:8080/api/events
    {
      "name": "Code Event",
      "date": "2023-06-21",
      "location": "TechnoPark ",
      "ticketsAvailable": 50
    }

     */
    @PostMapping
    public String createEvent(@RequestBody EventCreationRequest creationRequest) {
        eventService.createEvent(creationRequest);
        return "The event created successfully";
    }


}
