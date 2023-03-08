package app.carbooking.controller;

import app.carbooking.entity.Booking;
import app.carbooking.entity.Car;
import app.carbooking.model.AvailableBookingRequest;
import app.carbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rental")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PostMapping("/availableCars")
    public List<Car> getAvailableCars(@RequestBody AvailableBookingRequest availableBookingRequest) {
        return bookingService.getAvailableCars(availableBookingRequest);
    }

    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable Long bookingId, @RequestBody Booking bookingDetails) {
        return bookingService.updateBooking(bookingId, bookingDetails);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
