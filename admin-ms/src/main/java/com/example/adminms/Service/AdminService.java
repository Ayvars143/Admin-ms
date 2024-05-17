package com.example.adminms.Service;

import com.example.adminms.Entity.Location;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity addLocation(Location location);
}
