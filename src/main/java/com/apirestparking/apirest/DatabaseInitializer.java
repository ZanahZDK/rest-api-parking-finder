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
        parkingLot1.setPrice(800);
        parkingLotRepository.save(parkingLot1);

        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot2.setName("Parque Arauco");
        parkingLot2.setDirection("Las Condes");
        parkingLot2.setPrice(1000);
        parkingLotRepository.save(parkingLot2);

        ParkingLot parkingLot3 = new ParkingLot();
        parkingLot3.setName("Florida Center");
        parkingLot3.setDirection("La Florida");
        parkingLot3.setPrice(650);
        parkingLotRepository.save(parkingLot3);

        ParkingLot parkingLot4 = new ParkingLot();
        parkingLot4.setName("MallPlaza Vespucio");
        parkingLot4.setDirection("Vespucio");
        parkingLot4.setPrice(650);
        parkingLotRepository.save(parkingLot4);

        ParkingLot parkingLot5 = new ParkingLot();
        parkingLot5.setName("MallPlaza Alameda");
        parkingLot5.setDirection("Alameda");
        parkingLot5.setPrice(600);
        parkingLotRepository.save(parkingLot5);

        ParkingLot parkingLot6 = new ParkingLot();
        parkingLot6.setName("MallPlaza Egaña");
        parkingLot6.setDirection("La Reina");
        parkingLot6.setPrice(800);
        parkingLotRepository.save(parkingLot6);

        ParkingLot parkingLot7 = new ParkingLot();
        parkingLot7.setName("MallPlaza Sur");
        parkingLot7.setDirection("San Bernando");
        parkingLot7.setPrice(700);
        parkingLotRepository.save(parkingLot7);

        ParkingLot parkingLot8 = new ParkingLot();
        parkingLot8.setName("Paseo Quilin");
        parkingLot8.setDirection("Peñalolen");
        parkingLot8.setPrice(800);
        parkingLotRepository.save(parkingLot8);

        ParkingLot parkingLot9 = new ParkingLot();
        parkingLot9.setName("MallPlaza Los Dominicos");
        parkingLot9.setDirection("Las Condes");
        parkingLot9.setPrice(1000);
        parkingLotRepository.save(parkingLot9);

        ParkingLot parkingLot10 = new ParkingLot();
        parkingLot10.setName("Open Kennedy");
        parkingLot10.setDirection("Las Condes");
        parkingLot10.setPrice(900);
        parkingLotRepository.save(parkingLot10);

        ParkingLot parkingLot11 = new ParkingLot();
        parkingLot11.setName("Alto Las Condes");
        parkingLot11.setDirection("Las Condes");
        parkingLot11.setPrice(1200);
        parkingLotRepository.save(parkingLot11);

        ParkingLot parkingLot12 = new ParkingLot();
        parkingLot12.setName("Portal La Dehesa");
        parkingLot12.setDirection("La Dehesa");
        parkingLot12.setPrice(900);
        parkingLotRepository.save(parkingLot12);

        ParkingLot parkingLot13 = new ParkingLot();
        parkingLot13.setName("Portal La Reina");
        parkingLot13.setDirection("La Reina");
        parkingLot13.setPrice(900);
        parkingLotRepository.save(parkingLot13);

        ParkingLot parkingLot14 = new ParkingLot();
        parkingLot14.setName("Apumanque");
        parkingLot14.setDirection("Las Condes");
        parkingLot14.setPrice(900);
        parkingLotRepository.save(parkingLot14);

        ParkingLot parkingLot15 = new ParkingLot();
        parkingLot15.setName("Barrio Independencia");
        parkingLot15.setDirection("Independencia");
        parkingLot15.setPrice(900);
        parkingLotRepository.save(parkingLot15);

        ParkingLot parkingLot16 = new ParkingLot();
        parkingLot16.setName("Paseo San Bernardo");
        parkingLot16.setDirection("San Bernardo");
        parkingLot16.setPrice(900);
        parkingLotRepository.save(parkingLot16);

        ParkingLot parkingLot17 = new ParkingLot();
        parkingLot17.setName("MallPlaza Tobalaba");
        parkingLot17.setDirection("Providencia");
        parkingLot17.setPrice(900);
        parkingLotRepository.save(parkingLot17);

        ParkingLot parkingLot18= new ParkingLot();
        parkingLot18.setName("Open Puente Alto");
        parkingLot18.setDirection("Puente Alto");
        parkingLot18.setPrice(900);
        parkingLotRepository.save(parkingLot18);

        ParkingLot parkingLot19 = new ParkingLot();
        parkingLot19.setName("Espacio Urbano Puente Alto");
        parkingLot19.setDirection("Puente Alto");
        parkingLot19.setPrice(900);
        parkingLotRepository.save(parkingLot19);

        ParkingLot parkingLot20 = new ParkingLot();
        parkingLot20.setName("Arauco El Bosque");
        parkingLot20.setDirection("El Bosque");
        parkingLot20.setPrice(900);
        parkingLotRepository.save(parkingLot20);

        ParkingLot parkingLot21 = new ParkingLot();
        parkingLot21.setName("MallPlaza Oeste");
        parkingLot21.setDirection("Cerrillos");
        parkingLot21.setPrice(900);
        parkingLotRepository.save(parkingLot21);

        ParkingLot parkingLot22 = new ParkingLot();
        parkingLot22.setName("Mall Arauco Maipú");
        parkingLot22.setDirection("Maipu");
        parkingLot22.setPrice(900);
        parkingLotRepository.save(parkingLot22);

        ParkingLot parkingLot23 = new ParkingLot();
        parkingLot23.setName("Mall Arauco Quilicura");
        parkingLot23.setDirection("Quilicura");
        parkingLot23.setPrice(900);
        parkingLotRepository.save(parkingLot23);
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