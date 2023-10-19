package com.apirestparking.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apirestparking.apirest.models.ParkingLot;
import com.apirestparking.apirest.repositories.ParkingLotRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository;

    //OBTENER TODOS LOS ESTACIONAMIENTOS
    public ArrayList<ParkingLot> getAllParkingLots() {
        return (ArrayList <ParkingLot>) parkingLotRepository.findAll();
    }

    //GUARDAR UN ESTACIONAMIENTO NUEVO
    public ParkingLot saveParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    //OBTENER ESTACIONMIENTO POR ID
    public Optional<ParkingLot> getParkingLotById(Long id) {
        return parkingLotRepository.findById(id);
    }

    //ELIMINAR ESTACIONAMIENTO POR ID
    public boolean deleteParkingLot(Long id) {
        try {
            parkingLotRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    //OBTENER ESTACIONAMIENTO POR NOMBRE
    public List<ParkingLot> getParkingLotByName(String name) {
        return parkingLotRepository.findByName(name);
    }

    //OBTENER ESTACIONAMIENTO POR DIRECCION
    public List<ParkingLot> getParkingLotByDirection(String direction) {
        return parkingLotRepository.findByDirection(direction);
    }

}
