package com.apirestparking.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.apirestparking.apirest.models.ParkingLot;
import com.apirestparking.apirest.models.ParkingSpace;
import com.apirestparking.apirest.repositories.ParkingLotRepository;
import com.apirestparking.apirest.repositories.ParkingSpaceRepository;

@Service
public class ParkingSpaceService {
    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Scheduled(fixedRate = 5000)
    public void scheduleToggleParkingSpaces() {
        toggleRandomParkingSpaces();
    }

    //OBTENER ESPACIOS DISPONIBLES POR ID DE ESTACIONAMIENTO
    public void toggleRandomParkingSpaces() {
        List<Long> randomIds = parkingSpaceRepository.findRandomParkingSpaceIds();
        List<ParkingSpace> parkingSpaces = (List<ParkingSpace>) parkingSpaceRepository.findAllById(randomIds);
    
    // Invertir el valor de 'available' para cada espacio
        for (ParkingSpace space : parkingSpaces) {
            space.setAvailable(!space.getAvailable());
        }
        parkingSpaceRepository.saveAll(parkingSpaces);
    }

     //OBTENER TODOS LOS ESPACIOS
    public ArrayList<ParkingSpace> getAllParkingSpaces() {
        return (ArrayList <ParkingSpace>) parkingSpaceRepository.findAllByOrderByUbicationAsc();
    }

    //GUARDAR UN ESPACIO NUEVO
    public ParkingSpace saveParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    //OBTENER ESTACIONMIENTO POR ID
    public Optional<ParkingSpace> getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id);
    }

    //OBTENER ESPACIOS POR PISO
    public List<ParkingSpace> getParkingSpacesByFloor(String floor) {
        return parkingSpaceRepository.findByFloor(floor);
    }

    //OBTENER ESPACIOS POR PISO Y PARKING LOT
    public List<ParkingSpace> getParkingSpacesByFloorAndParkingLot(String floor, Long parkingLotId) {
        return parkingSpaceRepository.findByFloorAndParkingLotId(floor, parkingLotId);
    }

    public ParkingSpace addParkingSpaceToParkingLot(Long parkingLotId, ParkingSpace parkingSpace) {
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
                .orElseThrow(() -> new RuntimeException("ParkingLot not found")); 

        parkingSpace.setParkingLot(parkingLot);
        return parkingSpaceRepository.save(parkingSpace);
    }

    public void deleteParkingSpace(Long parkingSpaceId) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found")); 

        parkingSpaceRepository.delete(parkingSpace);
    }

    public ParkingSpace updateParkingSpace(Long parkingSpaceId, ParkingSpace parkingSpaceDetails) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found")); 

        parkingSpace.setFloor(parkingSpaceDetails.getFloor());
        parkingSpace.setUbication(parkingSpaceDetails.getUbication());
        parkingSpace.setAvailable(parkingSpaceDetails.getAvailable());
        
        return parkingSpaceRepository.save(parkingSpace);
    }

    public List<ParkingSpace> getParkingSpacesByParkingLot(Long parkingLotId) {
        return parkingSpaceRepository.findAllByParkingLotIdOrderByUbicationAsc(parkingLotId);
    }

    public List<ParkingSpace> getParkingSpacesByParkingLotAndFloor(Long parkingLotId, String floor) {
        return parkingSpaceRepository.findByParkingLotIdAndFloorOrderByUbicationAsc(parkingLotId, floor);
    }
}
