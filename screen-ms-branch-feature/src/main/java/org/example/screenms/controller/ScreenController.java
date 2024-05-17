package org.example.screenms.controller;

import org.example.screenms.entity.Screen;
import org.example.screenms.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screen-mapper")
public class ScreenController {
    @Autowired
    private ScreenService screenService;

    @GetMapping("/theaterId/{theaterId}")
    public List<Screen> getScreens(@PathVariable int theaterId) {
        return screenService.getScreensByTheater(theaterId);
    }
    @PostMapping("/addScreen")
    public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
        return screenService.addScreen(screen);
    }
    @GetMapping("/screen/{id}")
    public Screen getScreen(@PathVariable int id) {
        return screenService.getScreenById(id);
    }
    @PutMapping("/updateScreen/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable int id, @RequestBody Screen updatedScreen) {
        return screenService.updateScreen(id, updatedScreen);
    }
    @DeleteMapping("/deleteScreen/{id}")
    public ResponseEntity<String> deleteScreen(@PathVariable int id) {
        return screenService.deleteScreen(id);
    }

}
