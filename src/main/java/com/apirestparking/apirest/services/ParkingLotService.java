package com.apirestparking.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apirestparking.apirest.models.ParkingLot;
import com.apirestparking.apirest.models.ParkingSpace;
import com.apirestparking.apirest.repositories.ParkingLotRepository;
import com.apirestparking.apirest.repositories.ParkingSpaceRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    //OBTENER TODOS LOS ESTACIONAMIENTOS
    public ArrayList<ParkingLot> getAllParkingLots() {
        return (ArrayList <ParkingLot>) parkingLotRepository.findAllByOrderByIdAsc();
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

    public void addParkingSpace(ParkingSpace space) {
        parkingSpaceRepository.save(space);
        updateTotalSpaces(space.getParkingLot().getId());
    }

    public void removeParkingSpace(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
            .orElseThrow(() -> new EntityNotFoundException("ParkingSpace no encontrado"));
        parkingSpaceRepository.delete(space);
        updateTotalSpaces(space.getParkingLot().getId());
    }

    private void updateTotalSpaces(Long parkingLotId) {
        ParkingLot lot = parkingLotRepository.findById(parkingLotId).get();
        int totalSpaces = parkingSpaceRepository.countByParkingLotId(parkingLotId);
        lot.setTotalSpaces(totalSpaces);
        parkingLotRepository.save(lot);
    }

    public boolean deleteParkingLotById(Long id) {
        try {
            List<ParkingSpace> spaces = parkingSpaceRepository.findByParkingLotIdOrderByIdAsc(id);
            parkingSpaceRepository.deleteAll(spaces);
    
            parkingLotRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
    }
}
