package app.carbooking.controller;

import app.carbooking.entity.Car;
import app.carbooking.exception.ResourceNotFoundException;
import app.carbooking.repository.CarRepository;
import app.carbooking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    CarService carService;


    @GetMapping("")
    public List<Car> getAllCars() {
        return carRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Car createCar( @RequestParam(value = "image", required = false) MultipartFile image,
                          @RequestParam("name") String name, @RequestParam("model") String model,
                          @RequestParam("makeYear") String makeYear, @RequestParam("carType") String carType,
                          @RequestParam("color") String color, @RequestParam("pricePerDay") String pricePerDay,
                          @RequestParam("available") String available, @RequestParam("plateNumber") String plateNumber) throws IOException {
        Car car = new Car();
       car.setName(name);
       car.setModel(model);
       car.setColor(color);
       car.setMakeYear(Integer.parseInt(makeYear));
       car.setCarType(carType);
       car.setAvailable(Boolean.parseBoolean(available));
       car.setPricePerDay(Double.parseDouble(pricePerDay));
       car.setPlateNumber(plateNumber);
        System.out.println("isfile null"+ (null==image));
        System.out.println("car:"+car);
        if(image!=null){
        car.setImage(image.getBytes());}
        return carService.addCar(car);
    }

    @PutMapping(value="/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Car updateCar(@PathVariable int id, @RequestParam(value = "image", required = false) MultipartFile image,
                         @RequestParam("name") String name, @RequestParam("model") String model,
                         @RequestParam("makeYear") String makeYear, @RequestParam("carType") String carType,
                         @RequestParam("color") String color, @RequestParam("pricePerDay") String pricePerDay,
                         @RequestParam("available") String available, @RequestParam("plateNumber") String plateNumber) throws IOException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
        car.setName(name);
        car.setModel(model);
        car.setColor(color);
        car.setMakeYear(Integer.parseInt(makeYear));
        car.setCarType(carType);
        car.setAvailable(Boolean.parseBoolean(available));
        car.setPricePerDay(Double.parseDouble(pricePerDay));
        car.setPlateNumber(plateNumber);
        System.out.println("isfile null"+ (null==image));
        System.out.println("car:"+car);
        if(image!=null){
            car.setImage(image.getBytes());}
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
