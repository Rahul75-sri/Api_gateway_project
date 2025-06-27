package com.rahul.rating.RatingService.services.imp;

import com.rahul.rating.RatingService.entities.Rating;
import com.rahul.rating.RatingService.repositories.RatingRespository;
import com.rahul.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRespository respository;

    @Override
    public Rating create(Rating rating) {
        return respository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return respository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return respository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return respository.findByHotelId(hotelId);
    }
}
