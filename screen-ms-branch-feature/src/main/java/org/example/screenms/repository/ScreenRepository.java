package org.example.screenms.repository;

import org.example.screenms.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

    List<Screen> findByTheaterId(int id);
    List<Screen> findByName(String name);
}
