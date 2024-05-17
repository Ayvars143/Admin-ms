package org.example.screenms.service;

import org.example.screenms.entity.Screen;
import org.example.screenms.exception.ScreenNotFoundException;
import org.example.screenms.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    public int validation(Screen screen) {
        List<Screen> findScreen= screenRepository.findByName(screen.getName());
        return findScreen.size();
    }

    public ResponseEntity<Screen> addScreen(Screen screen) {
        Screen screenRepo = new Screen();
        if(validation(screen)==0){
            screenRepo = screenRepository.save(screen);
            return new ResponseEntity<>(screenRepo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(screenRepo, HttpStatus.CONFLICT);
        }
    }

    public Screen getScreenById(int id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new ScreenNotFoundException(id));
    }

    public ResponseEntity<Screen> updateScreen(int id, Screen updatedScreen) {
        return screenRepository.findById(id)
                .map(screen -> {
                    if(validation(updatedScreen)==0){
                        screen.setName(updatedScreen.getName());
                        screenRepository.save(screen);
                        return new ResponseEntity<>(screen, HttpStatus.OK);
                    }else{
                        return new ResponseEntity<>(screen, HttpStatus.CONFLICT);
                    }
                })
                .orElseThrow(() -> new ScreenNotFoundException(id));
    }

    public ResponseEntity<String> deleteScreen(int id) {
        // locationRepository.deleteById(id);
        if (screenRepository.existsById(id)) {
            screenRepository.deleteById(id);
            return ResponseEntity.ok(" Screen is Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Screen not found");
        }
    }
    public List<Screen> getScreensByTheater(int locationUUID) {
        List<Screen> screenList = new ArrayList<>();
        if (locationUUID != 0) {
            screenList.addAll(screenRepository.findByTheaterId(locationUUID));
        }
        return screenList;
    }


}
