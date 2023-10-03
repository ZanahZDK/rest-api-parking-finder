package com.apirestparking.apirest.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.apirestparking.apirest.models.ParkingSpace;

@Repository
public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace, Long>{

    @Query(value = "SELECT id FROM parking_space ORDER BY RANDOM() LIMIT 5", nativeQuery = true)
    List<Long> findRandomParkingSpaceIds();
}