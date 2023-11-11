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
        parkingLot1.setHourPrice(1500);
        parkingLot1.setMinutePrice(25);
        parkingLot1.setLatitud(-33.41679534637822);
        parkingLot1.setLongitud(-70.60473570944188);

        parkingLotRepository.save(parkingLot1);

        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot2.setName("Parque Arauco");
        parkingLot2.setDirection("Las Condes");
        parkingLot2.setHourPrice(1020);
        parkingLot2.setMinutePrice(17);
        parkingLot2.setLatitud(-33.404522426319375);
        parkingLot2.setLongitud(-70.57564364545044);
        parkingLotRepository.save(parkingLot2);


        ParkingLot parkingLot3 = new ParkingLot();
        parkingLot3.setName("Florida Center");
        parkingLot3.setDirection("La Florida");
        parkingLot3.setHourPrice(900);
        parkingLot3.setMinutePrice(15);
        parkingLot3.setLatitud(-33.51052431719239);
        parkingLot3.setLongitud(-70.60623010121134);
        parkingLotRepository.save(parkingLot3);

        ParkingLot parkingLot4 = new ParkingLot();
        parkingLot4.setName("MallPlaza Vespucio");
        parkingLot4.setDirection("Vespucio");
        parkingLot4.setHourPrice(960);
        parkingLot4.setMinutePrice(16);
        parkingLot4.setLatitud(-33.51909630360077);
        parkingLot4.setLongitud(-70.59913630305729);
        parkingLotRepository.save(parkingLot4);

        ParkingLot parkingLot5 = new ParkingLot();
        parkingLot5.setName("MallPlaza Alameda");
        parkingLot5.setDirection("Alameda");
        parkingLot5.setHourPrice(1800);
        parkingLot5.setMinutePrice(30);
        parkingLot5.setLatitud(-33.45331918521875);
        parkingLot5.setLongitud(-70.68240819474927);
        parkingLotRepository.save(parkingLot5);

        ParkingLot parkingLot6 = new ParkingLot();
        parkingLot6.setName("MallPlaza Egaña");
        parkingLot6.setDirection("La Reina");
        parkingLot6.setHourPrice(900);
        parkingLot6.setMinutePrice(15);
        parkingLot6.setLatitud(-33.453510856050265);
        parkingLot6.setLongitud(-70.5692061993674);
        parkingLotRepository.save(parkingLot6);

        ParkingLot parkingLot7 = new ParkingLot();
        parkingLot7.setName("MallPlaza Sur");
        parkingLot7.setDirection("San Bernando");
        parkingLot7.setHourPrice(0);
        parkingLot7.setMinutePrice(0);
        parkingLot7.setLatitud(-33.631822727459166);
        parkingLot7.setLongitud(-70.71056100908842);
        parkingLotRepository.save(parkingLot7);

        ParkingLot parkingLot8 = new ParkingLot();
        parkingLot8.setName("Paseo Quilin");
        parkingLot8.setDirection("Peñalolen");
        parkingLot8.setHourPrice(0);
        parkingLot8.setMinutePrice(0);
        parkingLot8.setLatitud(-33.48802493556529);
        parkingLot8.setLongitud(-70.57903941763668);
        parkingLotRepository.save(parkingLot8);

        ParkingLot parkingLot9 = new ParkingLot();
        parkingLot9.setName("MallPlaza Los Dominicos");
        parkingLot9.setDirection("Las Condes");
        parkingLot9.setHourPrice(900);
        parkingLot9.setMinutePrice(15);
        parkingLot9.setLatitud(-33.41498513654357);
        parkingLot9.setLongitud(-70.54061085105606);
        parkingLotRepository.save(parkingLot9);

        ParkingLot parkingLot10 = new ParkingLot();
        parkingLot10.setName("Open Kennedy");
        parkingLot10.setDirection("Las Condes");
        parkingLot10.setHourPrice(1200);
        parkingLot10.setMinutePrice(20);
        parkingLot10.setLatitud(-33.401107338700385);
        parkingLot10.setLongitud(-70.57533525668129);
        parkingLotRepository.save(parkingLot10);

        ParkingLot parkingLot11 = new ParkingLot();
        parkingLot11.setName("Alto Las Condes");
        parkingLot11.setDirection("Las Condes");
        parkingLot11.setHourPrice(900);
        parkingLot11.setMinutePrice(15);
        parkingLot11.setLatitud(-33.389659851232466);
        parkingLot11.setLongitud(-70.54672894965537);
        parkingLotRepository.save(parkingLot11);

        ParkingLot parkingLot12 = new ParkingLot();
        parkingLot12.setName("Portal La Dehesa");
        parkingLot12.setDirection("La Dehesa");
        parkingLot12.setHourPrice(900);
        parkingLot12.setMinutePrice(15);
        parkingLot12.setLatitud(-33.35747756939537);
        parkingLot12.setLongitud(-70.51527156635545);
        parkingLotRepository.save(parkingLot12);

        ParkingLot parkingLot13 = new ParkingLot();
        parkingLot13.setName("Portal La Reina");
        parkingLot13.setDirection("La Reina");
        parkingLot13.setHourPrice(0);
        parkingLot13.setMinutePrice(0);
        parkingLot13.setLatitud(-33.42785883779931);
        parkingLot13.setLongitud(-70.54077781435129);
        parkingLotRepository.save(parkingLot13);

        ParkingLot parkingLot14 = new ParkingLot();
        parkingLot14.setName("Apumanque");
        parkingLot14.setDirection("Las Condes");
        parkingLot14.setHourPrice(2100);
        parkingLot14.setMinutePrice(35);
        parkingLot14.setLatitud(-33.40981446818548);
        parkingLot14.setLongitud(-70.56740533158148);
        parkingLotRepository.save(parkingLot14);

        ParkingLot parkingLot15 = new ParkingLot();
        parkingLot15.setName("Barrio Independencia");
        parkingLot15.setDirection("Independencia");
        parkingLot15.setHourPrice(840);
        parkingLot15.setMinutePrice(14);
        parkingLot15.setLatitud(-33.42461133190757);
        parkingLot15.setLongitud(-70.65471095162547);
        parkingLotRepository.save(parkingLot15);

        ParkingLot parkingLot16 = new ParkingLot();
        parkingLot16.setName("Paseo San Bernardo");
        parkingLot16.setDirection("San Bernardo");
        parkingLot16.setHourPrice(480);
        parkingLot16.setMinutePrice(8);
        parkingLot16.setLatitud(-33.5951796396068);
        parkingLot16.setLongitud(-70.70659338360429);
        parkingLotRepository.save(parkingLot16);

        ParkingLot parkingLot17 = new ParkingLot();
        parkingLot17.setName("MallPlaza Tobalaba");
        parkingLot17.setDirection("Providencia");
        parkingLot17.setHourPrice(0);
        parkingLot17.setMinutePrice(0);
        parkingLot17.setLatitud(-33.568605042767366);
        parkingLot17.setLongitud(-70.55739560532753);
        parkingLotRepository.save(parkingLot17);

        ParkingLot parkingLot18= new ParkingLot();
        parkingLot18.setName("Open Puente Alto");
        parkingLot18.setDirection("Puente Alto");
        parkingLot18.setHourPrice(1200);
        parkingLot18.setMinutePrice(20);
        parkingLot18.setLatitud(-33.596911883208854);
        parkingLot18.setLongitud(-70.57736197206867);
        parkingLotRepository.save(parkingLot18);

        ParkingLot parkingLot19 = new ParkingLot();
        parkingLot19.setName("Espacio Urbano Puente Alto");
        parkingLot19.setDirection("Puente Alto");
        parkingLot19.setHourPrice(0);
        parkingLot19.setMinutePrice(0);
        parkingLot19.setLatitud(-33.599297921136966);
        parkingLot19.setLongitud(-70.57578483329922);
        parkingLotRepository.save(parkingLot19);

        ParkingLot parkingLot20 = new ParkingLot();
        parkingLot20.setName("Arauco El Bosque");
        parkingLot20.setDirection("El Bosque");
        parkingLot20.setHourPrice(900);
        parkingLot20.setMinutePrice(15);
        parkingLot20.setLatitud(-33.55354641417957);
        parkingLot20.setLongitud(-70.67700147925522);
        parkingLotRepository.save(parkingLot20);

        ParkingLot parkingLot21 = new ParkingLot();
        parkingLot21.setName("MallPlaza Oeste");
        parkingLot21.setDirection("Cerrillos");
        parkingLot21.setHourPrice(960);
        parkingLot21.setMinutePrice(16);
        parkingLot21.setLatitud(-33.516673054956996);
        parkingLot21.setLongitud(-70.71651881470568);
        parkingLotRepository.save(parkingLot21);

        ParkingLot parkingLot22 = new ParkingLot();
        parkingLot22.setName("Mall Arauco Maipú");
        parkingLot22.setDirection("Maipu");
        parkingLot22.setHourPrice(0);
        parkingLot22.setMinutePrice(0);
        parkingLot22.setLatitud(-33.481338105655624);
        parkingLot22.setLongitud(-70.75197996097535);
        parkingLotRepository.save(parkingLot22);

        ParkingLot parkingLot23 = new ParkingLot();
        parkingLot23.setName("Mall Arauco Quilicura");
        parkingLot23.setDirection("Quilicura");
        parkingLot23.setHourPrice(0);
        parkingLot23.setMinutePrice(0);
        parkingLot23.setLatitud(-33.36836056664303);
        parkingLot23.setLongitud(-70.73003835694364);
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