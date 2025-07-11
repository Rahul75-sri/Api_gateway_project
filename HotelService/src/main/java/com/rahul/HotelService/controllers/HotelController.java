package com.rahul.HotelService.controllers;


import com.rahul.HotelService.entities.Hotel;
import com.rahul.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
            return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

    }
    //get single
    @GetMapping ("/{hotelId}")
    public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }
    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok(hotelService.getAll());
    }
}
