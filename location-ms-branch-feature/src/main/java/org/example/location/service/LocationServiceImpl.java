package org.example.location.service;

import org.example.location.entity.Location;
import org.example.location.exception.LocationNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.example.location.repository.LocationRepository;

import java.util.List;

@Service
@Primary
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    public int validation(Location location) {
        List<Location> findLocation = locationRepository.findByName(location.getName());
        return findLocation.size();
    }

    public ResponseEntity<Location> addLocation(Location location) {
        Location locationSavedRepo = new Location();
        System.out.println(location);
        if(validation(location)==0){
            System.out.println(location);
            locationSavedRepo = locationRepository.save(location);
            return new ResponseEntity<>(locationSavedRepo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(locationSavedRepo, HttpStatus.ALREADY_REPORTED);
        }
    }

    public Location getLocation(int id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    public ResponseEntity<Location> updateLocation(int id, Location updatedLocation) {
        return locationRepository.findById(id)
                .map(location -> {
                    if(validation(updatedLocation)==0){
                        location.setName(updatedLocation.getName());
                        locationRepository.save(location);
                        return new ResponseEntity<>(location, HttpStatus.OK);
                    }else{
                        return new ResponseEntity<>(location, HttpStatus.CONFLICT);
                    }
                })
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

   public ResponseEntity<String> deleteLocation(int id) {
       // locationRepository.deleteById(id);
       if (locationRepository.existsById(id)) {
           locationRepository.deleteById(id);
           return ResponseEntity.ok(" City is Deleted successfully");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found");
       }
    }

    @Override
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations=locationRepository.findAll();
        if(!locations.isEmpty() && locations.size()>0){
            return ResponseEntity.ok(locations);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(locations);
        }
    }
}
