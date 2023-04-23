package app.carbooking.controller;

import app.carbooking.entity.Location;
import app.carbooking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    public LocationService locationService;
    @Autowired
    public LocationController(LocationService locationService){
        this.locationService=locationService;
    }

    @GetMapping("")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @PostMapping("")
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @PutMapping("/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location locationDetails) {
        return locationService.updateLocation(id, locationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
