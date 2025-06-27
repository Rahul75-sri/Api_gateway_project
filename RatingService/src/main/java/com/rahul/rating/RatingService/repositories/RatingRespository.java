package com.rahul.rating.RatingService.repositories;

import com.rahul.rating.RatingService.entities.Rating;
import org.apache.catalina.LifecycleState;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.*;

public interface RatingRespository  extends MongoRepository<Rating,String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
