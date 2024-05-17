package org.example.theater.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.theater.entity.Theater;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    List<Theater> findByLocationId(int id);
    List<Theater> findByName(String name);
}
