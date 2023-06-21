package com.alialsubhi.Codeline.Evaluation.Controllers;

import com.alialsubhi.Codeline.Evaluation.Models.Booking;
import com.alialsubhi.Codeline.Evaluation.Requests.BookingRequest;
import com.alialsubhi.Codeline.Evaluation.Services.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class EventBookingController {

    @Autowired
    EventBookingService eventBookingService;

    /*http://localhost:8080/api/booking/2/bookings?userId=4

    {
      "numberOfTickets": 11
    }

     */
    @PostMapping("/{eventId}/bookings")
    public Booking bookEvent(@PathVariable Long eventId, @RequestParam Long userId, @RequestBody BookingRequest bookingRequest) {
        int numberOfTickets = bookingRequest.getNumberOfTickets();
        return eventBookingService.bookEvent(eventId, userId, numberOfTickets);
    }


    //http://localhost:8080/api/booking
    @GetMapping
    public List<Booking> getAllEventBookings() {
        return eventBookingService.getAllEventBookings();
    }

    //http://localhost:8080/api/booking/2
    @DeleteMapping("/{id}")
    public void deleteEventBooking(@PathVariable("id") Long id) {
        eventBookingService.deleteEventBooking(id);
    }

}
//test the github