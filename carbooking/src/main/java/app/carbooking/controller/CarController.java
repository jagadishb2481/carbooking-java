package app.carbooking.controller;

import app.carbooking.entity.Car;
import app.carbooking.exception.ResourceNotFoundException;
import app.carbooking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public List<Car> getAllCars() {
        return carRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    }

    @PostMapping("")
    public Car createCar(@RequestBody Car car) {
        car.setAvailable(true);
        return carRepository.save(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car carDetails) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));

        car.setName(carDetails.getName());
        car.setModel(carDetails.getModel());
        car.setMakeYear(carDetails.getMakeYear());
        car.setPricePerDay(carDetails.getPricePerDay());
        car.setAvailable(carDetails.isAvailable());
        car.setColor(carDetails.getColor());
        car.setCarType(carDetails.getCarType());
        car.setPlateNumber(carDetails.getPlateNumber());
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));

        carRepository.delete(car);

        return ResponseEntity.ok().build();
    }
}
