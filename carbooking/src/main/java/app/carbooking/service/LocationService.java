package app.carbooking.service;

import app.carbooking.entity.Location;
import app.carbooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    public LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Location not found with id " + id));
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location locationDetails) {
        Location location = locationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Location not found with id " + id));

        location.setName(locationDetails.getName());
        location.setAddress(locationDetails.getAddress());
        location.setCity(locationDetails.getCity());
        location.setState(locationDetails.getState());
        location.setCountry(locationDetails.getCountry());
        location.setZipcode(locationDetails.getZipcode());

        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Location not found with id " + id));

        locationRepository.delete(location);
    }
}
