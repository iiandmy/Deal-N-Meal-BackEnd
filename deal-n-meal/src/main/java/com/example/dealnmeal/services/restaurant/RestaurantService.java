package com.example.dealnmeal.services.restaurant;

import com.example.dealnmeal.DAO.RestaurantDAO;
import com.example.dealnmeal.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantDAO restaurantDAO;
    @Autowired
    public RestaurantService(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    public void createNewRestaurant(Restaurant restaurant) {
        restaurantDAO.save(restaurant);
    }
}
