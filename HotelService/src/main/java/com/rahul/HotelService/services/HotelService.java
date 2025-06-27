package com.rahul.HotelService.services;
import com.rahul.HotelService.entities.Hotel;

import java.util.*;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}
