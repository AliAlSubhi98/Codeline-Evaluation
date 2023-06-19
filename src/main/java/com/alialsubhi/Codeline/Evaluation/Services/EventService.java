package com.alialsubhi.Codeline.Evaluation.Services;

import com.alialsubhi.Codeline.Evaluation.Models.Event;
import com.alialsubhi.Codeline.Evaluation.Repo.EventRepo;
import com.alialsubhi.Codeline.Evaluation.Requests.EventCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
