package org.example.screenms.service;

import org.example.screenms.entity.Screen;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScreenService {

    List<Screen> getScreensByTheater(int theaterId);

    ResponseEntity<Screen> addScreen(Screen screen);

    Screen getScreenById(int id);

    ResponseEntity<Screen> updateScreen(int id, Screen updatedScreen);

    ResponseEntity<String> deleteScreen(int id);
    public int validation(Screen screen);
}
