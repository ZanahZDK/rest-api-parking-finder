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
    private String price;

    // Relación uno a muchos con ParkingSpace
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpace> parkingSpaces = new ArrayList<>();

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice(){
        return price;
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

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }
    
}
