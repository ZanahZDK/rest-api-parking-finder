package com.apirestparking.apirest.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private String direction;
    private int hourPrice;
    private int minutePrice;
    private int totalSpaces;
    private double latitud; 
    private double longitud;

    // Relación 1:N con ParkingSpace
    @OneToMany(mappedBy = "parkingLot", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, orphanRemoval = false)
    private List<ParkingSpace> parkingSpaces = new ArrayList<>();

    public void setHourPrice(int hourPrice) {
        this.hourPrice = hourPrice;
    }

    public int getHourPrice(){
        return hourPrice;
    }

    public void setMinutePrice(int minutePrice) {
        this.minutePrice = minutePrice;
    }

    public int getMinutePrice(){
        return minutePrice;
    }
    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public int getTotalSpaces(){
        return totalSpaces;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection(){
        return direction;
    }

        public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLatitud(){
        return latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLongitud(){
        return longitud;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}
