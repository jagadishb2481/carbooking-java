package app.carbooking.controller;

import app.carbooking.entity.Car;
import app.carbooking.entity.Customer;
import app.carbooking.exception.ResourceNotFoundException;
import app.carbooking.model.AuthRequest;
import app.carbooking.model.TokenResponse;
import app.carbooking.repository.CarRepository;
import app.carbooking.service.CustomerService;
import app.carbooking.util.JwtUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    CustomerService customerService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("login")
    public Customer login(@RequestBody Customer customer) {
        return customerService.getCustomerByUsernameAndPassword(customer.getUsername(), customer.getPassword());
    }

    @PostMapping("/authenticate")
    public TokenResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        TokenResponse tokenResponse = null;
        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            tokenResponse = new TokenResponse();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //final String token = jwtTokenUtil.generateToken(authentication);
            tokenResponse.setJwtToken(jwtUtil.generateToken(authentication));
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return tokenResponse;
    }

}
