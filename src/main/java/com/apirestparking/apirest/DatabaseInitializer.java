package com.apirestparking.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.apirestparking.apirest.models.ParkingLot;
import com.apirestparking.apirest.models.ParkingSpace;
import com.apirestparking.apirest.repositories.ParkingLotRepository;
import com.apirestparking.apirest.repositories.ParkingSpaceRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Value("${database.initialize}")
    private boolean initializeDatabase;

    @PostConstruct
    public void initAndSeedDatabase() {
        if (initializeDatabase) {
            initDatabase();
            seedDatabase();
        }
    }

    public void initDatabase() {
        // Crear y guardar algunos parking_lots
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setName("Costanera Center");
        parkingLot1.setDirection("Providencia");
        parkingLot1.setPrice("$800 por hora");
        parkingLotRepository.save(parkingLot1);

        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot2.setName("Parque Arauco");
        parkingLot2.setDirection("Las Condes");
        parkingLot2.setPrice("$1000 por hora");
        parkingLotRepository.save(parkingLot2);
    }

    public void seedDatabase() {
        int spacesPerParkingLot = 75; // Define aquí la cantidad de espacios por estacionamiento
        List<ParkingLot> parkingLots = (List<ParkingLot>) parkingLotRepository.findAll();

        for (ParkingLot parkingLot : parkingLots) {
            int numberCounter = 1;
            char letterCounter = 'A';
            int floorCounter = 1;

            for (int i = 0; i < spacesPerParkingLot; i++) {
                ParkingSpace parkingSpace = new ParkingSpace();
                parkingSpace.setFloor("Nivel " + floorCounter);
                parkingSpace.setUbication(letterCounter + String.valueOf(numberCounter));
                parkingSpace.setAvailable(true);
                parkingSpace.setParkingLot(parkingLot);

                parkingSpaceRepository.save(parkingSpace);

                numberCounter++;


                if (numberCounter > 5) {
                    numberCounter = 1;
                    letterCounter++;
                }

                if (letterCounter > 'E') {
                    letterCounter = 'A';
                    floorCounter++;
                }
            }
        }
    }
}