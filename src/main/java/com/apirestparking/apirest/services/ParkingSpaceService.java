package com.apirestparking.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.apirestparking.apirest.models.ParkingSpace;
import com.apirestparking.apirest.repositories.ParkingSpaceRepository;

@Service
public class ParkingSpaceService {
    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

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
        return (ArrayList <ParkingSpace>) parkingSpaceRepository.findAll();
    }

    //GUARDAR UN ESPACIO NUEVO
    public ParkingSpace saveParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    //OBTENER ESTACIONMIENTO POR ID
    public Optional<ParkingSpace> getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id);
    }

    //ELIMINAR ESPACIO POR ID
    public boolean deleteParkingSpace(Long id) {
        try {
            parkingSpaceRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
