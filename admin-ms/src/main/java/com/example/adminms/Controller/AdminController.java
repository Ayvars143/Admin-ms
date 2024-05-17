package com.example.adminms.Controller;


import com.example.adminms.Entity.Location;
import com.example.adminms.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addLocation")
    public ResponseEntity addLocation(@RequestBody Location location){
          return adminService.addLocation(location);
    }
}
