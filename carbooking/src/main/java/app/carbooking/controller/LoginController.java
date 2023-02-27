package app.carbooking.controller;

import app.carbooking.entity.Car;
import app.carbooking.entity.Customer;
import app.carbooking.exception.ResourceNotFoundException;
import app.carbooking.repository.CarRepository;
import app.carbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @Autowired
    CustomerService customerService;
    @PostMapping("login")
    public Customer login(@RequestBody Customer customer) {
        return customerService.getCustomerByUsernameAndPassword(customer.getUsername(), customer.getPassword());
    }
}
