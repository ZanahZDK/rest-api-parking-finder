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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestparking.apirest.models.ParkingLot;
import com.apirestparking.apirest.services.ParkingLotService;

@RestController
@RequestMapping("/parking_lot")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping()
    public ArrayList<ParkingLot> getAllParkingLots() {
        return parkingLotService.getAllParkingLots();
    }

    @PostMapping()
    public ParkingLot saveParkingLot(@RequestBody ParkingLot parkingLot) {
        return this.parkingLotService.saveParkingLot(parkingLot);
    }

    @GetMapping(path = "/{id}")
    public Optional<ParkingLot> getParkingLotById(@PathVariable("id") Long id) {
        return this.parkingLotService.getParkingLotById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteParkingLot(@PathVariable("id") Long id) {
        boolean ok = this.parkingLotService.deleteParkingLot(id);
        if (ok) {
            return "Se eliminó el estacionamiento con id " + id;
        } else {
            return "No se pudo eliminar el estacionamiento con id " + id;
        }
    }
        @GetMapping("/{id}/price")
        public ResponseEntity<Integer> getParkingLotPrice(@PathVariable Long id) {
            Optional<ParkingLot> parkingLot = parkingLotService.getParkingLotById(id);
            if (parkingLot.isPresent()) {
                return new ResponseEntity<>(parkingLot.get().getPrice(), HttpStatus.OK);
            } 
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    
}
