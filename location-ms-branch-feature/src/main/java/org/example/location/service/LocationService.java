package org.example.location.service;

import org.example.location.entity.Location;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationService {

    public ResponseEntity<Location> addLocation(Location location);

    public Location getLocation(int id);

    public ResponseEntity<Location> updateLocation(int id, Location updatedLocation);

    public ResponseEntity<String> deleteLocation(int id);

    ResponseEntity<List<Location>> getAllLocations();
}
