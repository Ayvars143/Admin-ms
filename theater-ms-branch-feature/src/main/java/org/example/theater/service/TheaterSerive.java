package org.example.theater.service;

import org.example.theater.entity.Theater;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TheaterSerive {
    List<Theater> getTheatersByLocation(int locationId);

    ResponseEntity<Theater> addTheater(Theater theater);

    Theater getTheaterById(int id);

    ResponseEntity<Theater> updateTheater(int id, Theater updatedTheater);

    ResponseEntity<String> deleteTheater(int id);
    public int validation(Theater theater);

}
