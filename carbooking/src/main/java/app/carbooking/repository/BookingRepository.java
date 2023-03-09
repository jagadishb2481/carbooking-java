package app.carbooking.repository;

import app.carbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

   /* @Query("SELECT car FROM Car car " +
            "WHERE car.id NOT IN " +
            "(SELECT b.car.id FROM Booking b " +
            "WHERE (b.startDateTime BETWEEN :rentalDate AND :returnDate) " +
            "OR (b.endDateTime BETWEEN :rentalDate AND :returnDate)) " +
            "AND b.pickupLocation.id = : pickupLocationId) " )
    List<Car> findAvailableCars(@Param("pickupLocationId") Integer pickupLocationId,
                                @Param("rentalDate") LocalDateTime rentalDate,
                                @Param("returnDate") LocalDateTime returnDate);*/

}
