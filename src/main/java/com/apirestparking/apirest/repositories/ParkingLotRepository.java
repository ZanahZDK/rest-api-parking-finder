package com.apirestparking.apirest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.apirestparking.apirest.models.ParkingLot;
import com.apirestparking.apirest.models.ParkingSpace;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long>{

    List<ParkingLot> findAllByOrderByIdAsc();

    List<ParkingSpace> findByParkingLotId(Long parkingLotId);

}
    

