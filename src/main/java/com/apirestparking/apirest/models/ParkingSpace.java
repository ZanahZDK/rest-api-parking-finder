package com.apirestparking.apirest.models;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_space")
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String floor;
    private String ubication;
    private Boolean available;

     // Relación muchos a uno con ParkingLot
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="parking_lot_id")
     private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFloor(){
        return floor;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getUbication(){
        return ubication;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable(){
        return available;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}
