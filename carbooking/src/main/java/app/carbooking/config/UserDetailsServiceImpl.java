package app.carbooking.config;

import app.carbooking.entity.Customer;
import app.carbooking.exception.ResourceNotFoundException;
import app.carbooking.model.CustomUserDetails;
import app.carbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository userRepository;

    @Override
    public UserDetails  loadUserByUsername(String username) throws ResourceNotFoundException {
        Customer user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "username", username));

        return new CustomUserDetails(user);
    }
}