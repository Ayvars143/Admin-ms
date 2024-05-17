package org.example.theater.controller;


import java.util.List;

import org.example.theater.service.TheaterSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.theater.entity.Theater;


@RestController
@RequestMapping("/theater-mapper")
public class TheaterController {

    @Autowired
    private TheaterSerive theaterService;

    @GetMapping("/locationId/{locationId}")
    public List<Theater> getTheaters(@PathVariable int locationId) {
        return theaterService.getTheatersByLocation(locationId);
    }
    @PostMapping("/addtheater")
    public ResponseEntity<Theater> addTheater(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }
    @GetMapping("/theater/{id}")
    public Theater getTheater(@PathVariable int id) {
        return theaterService.getTheaterById(id);

    }

    @PutMapping("/updatetheater/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable int id, @RequestBody Theater updatedTheater) {
        return theaterService.updateTheater(id, updatedTheater);
    }

    @DeleteMapping("/deletetheater/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable int id) {
        return theaterService.deleteTheater(id);
    }

}
