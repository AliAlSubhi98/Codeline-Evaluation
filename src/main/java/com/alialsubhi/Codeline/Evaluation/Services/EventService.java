package com.alialsubhi.Codeline.Evaluation.Services;

import com.alialsubhi.Codeline.Evaluation.Models.Event;
import com.alialsubhi.Codeline.Evaluation.Repo.EventRepo;
import com.alialsubhi.Codeline.Evaluation.Requests.EventCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepo eventRepository;

    public Event createEvent(EventCreationRequest creationRequest){
        Event event = new Event();
        event.setName(creationRequest.getName());
        event.setDate(creationRequest.getDate());
        event.setLocation(creationRequest.getLocation());
        event.setTicketsAvailable(creationRequest.getTicketsAvailable());

        return eventRepository.save(event);
    }

    public Event getEventByID(Long id){
        return eventRepository.findById(id).get();
    }

    public List<Event> searchEvents(String location, LocalDate dateFrom, LocalDate dateTo, String eventName) {
        return eventRepository.search(location, dateFrom, dateTo, eventName);
    }

    

}
