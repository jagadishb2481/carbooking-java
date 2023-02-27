package app.carbooking.service;

import app.carbooking.entity.Booking;
import app.carbooking.exception.ResourceNotFoundException;
import app.carbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", bookingId));
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long bookingId, Booking bookingDetails) {
        Booking booking = getBookingById(bookingId);
        booking.setCustomer(bookingDetails.getCustomer());
        booking.setCar(bookingDetails.getCar());
        booking.setStartDateTime(bookingDetails.getStartDateTime());
        booking.setEndDateTime(bookingDetails.getEndDateTime());
        booking.setTotalPrice(bookingDetails.getTotalPrice());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);
        bookingRepository.delete(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
