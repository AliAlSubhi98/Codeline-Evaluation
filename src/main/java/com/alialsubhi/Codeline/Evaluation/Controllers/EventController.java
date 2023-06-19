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

    @GetMapping
    public List<Event> searchEvents(@RequestParam(required = false) String location,
                                    @RequestParam(required = false) LocalDate dateFrom,
                                    @RequestParam(required = false) LocalDate dateTo,
                                    @RequestParam(required = false) String eventName) {
        return eventService.searchEvents(location, dateFrom, dateTo, eventName);
    }

    @PostMapping
    public void createEvent(@RequestBody EventCreationRequest creationRequest) {
        eventService.createEvent(creationRequest);
    }


}
