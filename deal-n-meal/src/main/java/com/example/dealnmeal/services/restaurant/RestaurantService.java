package com.example.dealnmeal.services.restaurant;

import com.example.dealnmeal.models.Restaurant;
import net.sf.json.JSONObject;

public interface RestaurantService {

    Restaurant saveRestaurant(JSONObject restaurantJson);
}
