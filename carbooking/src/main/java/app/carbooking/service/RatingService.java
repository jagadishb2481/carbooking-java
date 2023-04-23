package app.carbooking.service;

import app.carbooking.entity.Car;
import app.carbooking.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    
    public Double getAverageRatingForCar(Car car) {
        return null;//ratingRepository.findAverageRatingByCar(car);
    }
    
    public List<Car> getCarsWithHighestRatings() {
        return null;//ratingRepository.findCarsWithHighestRatings();
    }
}
