package com.alialsubhi.Codeline.Evaluation.Controllers;

import com.alialsubhi.Codeline.Evaluation.Models.Booking;
import com.alialsubhi.Codeline.Evaluation.Requests.BookingRequest;
import com.alialsubhi.Codeline.Evaluation.Services.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> deleteEventBooking(@PathVariable("id") Long id) {
        boolean cancellationSuccessfully = eventBookingService.deleteEventBooking(id);

        if (cancellationSuccessfully){
            String message = "Booking cancellation successful.";
            return ResponseEntity.ok(message);
        }
        else{
            String errorMessage = "Failed to cancel booking.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }



}
//test the github