package com.apirestparking.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apirestparking.apirest.models.ParkingSpace;
import com.apirestparking.apirest.services.ParkingSpaceService;

@RequestMapping("/parking_space")
@Controller
public class ParkingSpaceViewController {
    @Autowired
    ParkingSpaceService parkingSpaceService;

        @GetMapping("/spaces")
        public String showParkingSpaces(Model model) {
            List<ParkingSpace> spaces = parkingSpaceService.getAllParkingSpaces();
            model.addAttribute("parkingSpaces", spaces);
        return "spaces";
        } 
        
        @ResponseBody
        @GetMapping("/byFloor/{floor}")
        public List<ParkingSpace> getParkingSpacesByFloor(@PathVariable("floor") String floor) {
            return parkingSpaceService.getParkingSpacesByFloor(floor);
        }

        @ResponseBody
        @GetMapping("/byFloorAndParkingLot/{floor}/{parkingLotId}")
        public List<ParkingSpace> getParkingSpacesByFloorAndParkingLot(
            @PathVariable("floor") String floor, 
            @PathVariable("parkingLotId") Long parkingLotId) {
            
            return parkingSpaceService.getParkingSpacesByFloorAndParkingLot(floor, parkingLotId);
}
    
}
