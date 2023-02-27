package app.carbooking.service;

import app.carbooking.entity.Car;
import app.carbooking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getId()).orElse(null);
        if (existingCar != null) {
            existingCar.setName(car.getName());
            existingCar.setPlateNumber(car.getPlateNumber());
            existingCar.setModel(car.getModel());
            existingCar.setMakeYear(car.getMakeYear());
            existingCar.setPricePerDay(car.getPricePerDay());
            existingCar.setAvailable(car.isAvailable());
            return carRepository.save(existingCar);
        } else {
            return null;
        }
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
