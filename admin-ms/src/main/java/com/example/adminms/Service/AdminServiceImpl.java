package com.example.adminms.Service;

import com.example.adminms.Entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseEntity addLocation(Location location) {
        HttpHeaders headrs= new HttpHeaders();
        headrs.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Location> entity=new HttpEntity<Location>(location,headrs);

        System.out.println("start porcess==========================");
        ResponseEntity<Location> response=restTemplate.exchange("http://localhost:8081/location-ms/location-mapper/addlocations", HttpMethod.POST,entity,Location.class);
        System.out.println(response);
        if(response != null && response.getStatusCode().value()==200) {
            return ResponseEntity.ok(response.getBody().getName() + " Location is added successfully..!");
        }else{
            return ResponseEntity.ok(location.getName()+ " Location is already exist..!");
        }
    }
}
