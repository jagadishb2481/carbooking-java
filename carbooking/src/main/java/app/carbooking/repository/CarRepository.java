package app.carbooking.repository;

import app.carbooking.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByOrderByIdAsc();
    @Query("SELECT c FROM Car c LEFT JOIN Booking b " +
            "ON c.id = b.car.id AND b.pickupLocation.id = :pickupLocationId " +
            "AND ((b.startDate <= :rentalDate AND b.endDate >= :rentalDate) " +
            "OR (b.startDate <= :returnDate AND b.endDate >= :returnDate) " +
            "OR (b.startDate >= :rentalDate AND b.endDate <= :returnDate)) " +
            "WHERE b.car.id IS NULL AND c.location.id = :pickupLocationId")
    List<Car> findAvailableCars(@Param("pickupLocationId") Integer pickupLocationId,
                                @Param("rentalDate") LocalDate rentalDate,
                                @Param("returnDate") LocalDate returnDate);
}
