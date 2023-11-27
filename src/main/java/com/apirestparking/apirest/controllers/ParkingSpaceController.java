package com.apirestparking.apirest.controllers;

import java.util.ArrayList;
import java.util.List;
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
import com.apirestparking.apirest.services.ParkingSpaceService;


@RestController
@RequestMapping("/parking_space")
public class ParkingSpaceController {
    @Autowired
    ParkingSpaceService parkingSpaceService;

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

    @PostMapping("/add/{parkingLotId}")
    public ResponseEntity<ParkingSpace> addParkingSpaceToParkingLot(@PathVariable Long parkingLotId, @RequestBody ParkingSpace parkingSpace) {
        ParkingSpace newParkingSpace = parkingSpaceService.addParkingSpaceToParkingLot(parkingLotId, parkingSpace);
        return new ResponseEntity<>(newParkingSpace, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{parkingSpaceId}")
    public ResponseEntity<?> deleteParkingSpace(@PathVariable Long parkingSpaceId) {
        parkingSpaceService.deleteParkingSpace(parkingSpaceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{parkingSpaceId}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(@PathVariable Long parkingSpaceId, @RequestBody ParkingSpace parkingSpaceDetails) {
        ParkingSpace updatedParkingSpace = parkingSpaceService.updateParkingSpace(parkingSpaceId, parkingSpaceDetails);
        return new ResponseEntity<>(updatedParkingSpace, HttpStatus.OK);
    }

    @GetMapping("/by-parking-lot/{parkingLotId}")
    public ResponseEntity<List<ParkingSpace>> getParkingSpacesByParkingLot(@PathVariable Long parkingLotId) {
        List<ParkingSpace> parkingSpaces = parkingSpaceService.getParkingSpacesByParkingLot(parkingLotId);
        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/by-parking-lot/{parkingLotId}/floor/{floor}")
    public ResponseEntity<List<ParkingSpace>> getParkingSpacesByParkingLotAndFloor(@PathVariable Long parkingLotId, @PathVariable String floor) {
        List<ParkingSpace> parkingSpaces = parkingSpaceService.getParkingSpacesByParkingLotAndFloor(parkingLotId, floor);
        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @PostMapping("/add-to-floor/{parkingLotId}/{floor}")
    public ResponseEntity<ParkingSpace> addParkingSpaceToFloorAndLot(@PathVariable Long parkingLotId, 
                                                                 @PathVariable String floor, 
                                                                 @RequestBody ParkingSpace parkingSpace) {
    ParkingSpace newParkingSpace = parkingSpaceService.addParkingSpaceToFloorAndLot(parkingLotId, floor, parkingSpace);
    return new ResponseEntity<>(newParkingSpace, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-multiple")
    public ResponseEntity<?> deleteMultipleParkingSpaces(@RequestBody List<Long> parkingSpaceIds) {
        parkingSpaceService.deleteMultipleParkingSpaces(parkingSpaceIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
