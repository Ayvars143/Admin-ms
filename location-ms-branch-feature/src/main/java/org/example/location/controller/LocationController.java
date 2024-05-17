package org.example.location.controller;

import org.example.location.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.location.service.LocationService;

import java.util.List;

@RestController
@RequestMapping(value = "/location-mapper",consumes = {"application/json"},produces = {"application/json"})
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/addlocations")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        //return "location";
        return locationService.addLocation(location);
    }

    @GetMapping("/locations/{id}")
    public Location getLocation(@PathVariable int id) {
        return locationService.getLocation(id);

    }

    @PutMapping("/updatelocations/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable int id, @RequestBody Location updatedLocation) {
        return locationService.updateLocation(id, updatedLocation);
    }

    @DeleteMapping("/deletelocations/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable int id) {
        return locationService.deleteLocation(id);
    }

    @GetMapping("/fetch/all/locations")
    public ResponseEntity<List<Location>> getAllLocations(){
        return locationService.getAllLocations();
    }
}
