package org.example.theater.service;

import java.util.ArrayList;
import java.util.List;

import org.example.theater.exception.TheaterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.example.theater.entity.Theater;
import org.example.theater.repository.TheaterRepository;


@Service
public class TheaterService implements TheaterSerive{
    @Autowired
    private TheaterRepository theaterRepository;

    public int validation(Theater theater) {
        List<Theater> findTheater= theaterRepository.findByName(theater.getName());
        return findTheater.size();
    }
    public  ResponseEntity<Theater> addTheater(Theater theater) {
        Theater theaterRepo = new Theater();
        if(validation(theater)==0){
            theaterRepo = theaterRepository.save(theater);
            return new ResponseEntity<>(theaterRepo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(theaterRepo, HttpStatus.CONFLICT);
        }
    }
    public Theater getTheaterById(int id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new TheaterNotFoundException(id));
    }



    public ResponseEntity<Theater> updateTheater(int id, Theater updatedTheater) {
        return theaterRepository.findById(id)
                .map(theater -> {
                    if(validation(updatedTheater)==0){
                        theater.setName(updatedTheater.getName());
                        theaterRepository.save(theater);
                        return new ResponseEntity<>(theater, HttpStatus.OK);
                    }else{
                        return new ResponseEntity<>(theater, HttpStatus.CONFLICT);
                    }
                })
                .orElseThrow(() -> new TheaterNotFoundException(id));
    }

    public ResponseEntity<String> deleteTheater(int id) {
        // locationRepository.deleteById(id);
        if (theaterRepository.existsById(id)) {
            theaterRepository.deleteById(id);
            return ResponseEntity.ok(" City is Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City not found");
        }
    }
    public List<Theater> getTheatersByLocation(int locationUUID) {
        List<Theater> theaterList = new ArrayList<>();
        if (locationUUID != 0) {
            theaterList.addAll(theaterRepository.findByLocationId(locationUUID));
        }
        return theaterList;
    }
}
