package com.alialsubhi.Codeline.Evaluation.Services;

import com.alialsubhi.Codeline.Evaluation.Models.Booking;
import com.alialsubhi.Codeline.Evaluation.Models.Event;
import com.alialsubhi.Codeline.Evaluation.Models.User;
import com.alialsubhi.Codeline.Evaluation.Repo.BookingRepo;
import com.alialsubhi.Codeline.Evaluation.Repo.EventRepo;
import com.alialsubhi.Codeline.Evaluation.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingService {

    @Autowired
    EventRepo eventRepository;

    @Autowired
    BookingRepo bookingRepository;

    @Autowired
    UserRepo userRepository;

    public Booking bookEvent(Long eventId, Long userId, int numberOfTickets) {
        Event event = eventRepository.findById(eventId).get();
        if (event.getTicketsAvailable() == 0) {
            throw new IllegalArgumentException("There is no Tickets for this event.");
        }
        if (event.getTicketsAvailable() < numberOfTickets) {
            throw new IllegalArgumentException("Insufficient tickets available for booking " +
                    "Tickets available only " + event.getTicketsAvailable()  );
        }

        event.setTicketsAvailable(event.getTicketsAvailable() - numberOfTickets);
        eventRepository.save(event);

        User user = userRepository.findById(userId).get();

        Booking booking = new Booking();
        booking.setEvent(event);
        booking.setUser(user);
        booking.setNumberOfTickets(numberOfTickets);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllEventBookings() {
        return bookingRepository.findAll();
    }

    public void deleteEventBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
