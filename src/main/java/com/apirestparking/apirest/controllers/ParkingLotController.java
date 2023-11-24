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

    @PutMapping()
    public ParkingLot saveParkingLot(@RequestBody ParkingLot parkingLot) {
        return this.parkingLotService.saveParkingLot(parkingLot);
    }

    //AGREGAR ESTACIONAMIENTO
    @PostMapping()
    public ResponseEntity<ParkingLot> addParkingLot(@RequestBody ParkingLot parkingLot) {
        ParkingLot newParkingLot = parkingLotService.saveParkingLot(parkingLot);
        if (newParkingLot != null) {
            return ResponseEntity.ok(newParkingLot);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<ParkingLot> getParkingLotById(@PathVariable("id") Long id) {
        return this.parkingLotService.getParkingLotById(id);
    }

    // ELIMINAR ESTACIONAMIENTO
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteParkingLot(@PathVariable("id") Long id) {
        boolean isDeleted = parkingLotService.deleteParkingLotById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Estacionamiento con id " + id + " eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo eliminar el estacionamiento con id " + id);
        }
    }

    @GetMapping("/{id}/hourPrice")
    public ResponseEntity<Integer> getParkingLotPrice(@PathVariable Long id) {
        Optional<ParkingLot> parkingLot = parkingLotService.getParkingLotById(id);
        if (parkingLot.isPresent()) {
            return new ResponseEntity<>(parkingLot.get().getHourPrice(), HttpStatus.OK);
        } 
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/minutePrice")
    public ResponseEntity<Integer> getParkingLotPriceMin(@PathVariable Long id) {
        Optional<ParkingLot> parkingLot = parkingLotService.getParkingLotById(id);
        if (parkingLot.isPresent()) {
            return new ResponseEntity<>(parkingLot.get().getMinutePrice(), HttpStatus.OK);
        } 
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //EDITAR ESTACIONAMIENTO
    @PostMapping(path = "/{id}")
    public ResponseEntity<ParkingLot> updateParkingLot(@PathVariable("id") Long id, @RequestBody ParkingLot parkingLot) {
        return parkingLotService.getParkingLotById(id)
                .map(existingParkingLot -> {
                    parkingLot.setId(id);
                    ParkingLot updatedParkingLot = parkingLotService.saveParkingLot(parkingLot);
                    return new ResponseEntity<>(updatedParkingLot, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}
