package com.apirestparking.apirest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirestparking.apirest.models.ParkingSpace;
import com.apirestparking.apirest.repositories.ParkingSpaceRepository;
import com.apirestparking.apirest.services.ParkingSpaceService;


@RestController
@RequestMapping("/parking_space")
public class ParkingSpaceController {
    @Autowired
    ParkingSpaceService parkingSpaceService;
    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

    @GetMapping()
    public ArrayList<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceService.getAllParkingSpaces();
    }

    @PostMapping()
    public ParkingSpace saveParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        return this.parkingSpaceService.saveParkingSpace(parkingSpace);
    }

    @GetMapping(path = "/{id}")
    public Optional<ParkingSpace> getParkingSpaceById(@PathVariable("id") Long id) {
        return this.parkingSpaceService.getParkingSpaceById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteParkingSpace(@PathVariable("id") Long id) {
        boolean ok = this.parkingSpaceService.deleteParkingSpace(id);
        if (ok) {
            return "Se eliminó el espacio con id " + id;
        } else {
            return "No se pudo eliminar el espacio con id " + id;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(@PathVariable("id") long id, @RequestBody ParkingSpace parkingSpaceDetails) {
        Optional<ParkingSpace> parkingSpaceData = parkingSpaceRepository.findById(id);
        
        if (parkingSpaceData.isPresent()) {
            ParkingSpace _parkingSpace = parkingSpaceData.get();
            _parkingSpace.setFloor(parkingSpaceDetails.getFloor());
            _parkingSpace.setUbication(parkingSpaceDetails.getUbication());
            _parkingSpace.setAvailable(parkingSpaceDetails.getAvailable());
            _parkingSpace.setParkingLot(parkingSpaceDetails.getParkingLot());
            
            return new ResponseEntity<>(parkingSpaceRepository.save(_parkingSpace), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
