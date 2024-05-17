package org.example.location.repository;

import org.example.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    //Location findByName(String name);
    //@Query(value = "select * from location where location_name=:name",nativeQuery = true)
    List<Location> findByName(String name);
}
