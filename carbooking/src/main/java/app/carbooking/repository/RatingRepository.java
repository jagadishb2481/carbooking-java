package app.carbooking.repository;

import app.carbooking.entity.Car;
import app.carbooking.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    public Double findAverageRatingByCar(Car car);
    public List<Car> findCarsWithHighestRatings();
}
