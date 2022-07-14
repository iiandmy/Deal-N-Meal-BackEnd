package com.example.dealnmeal.controllers;

import com.example.dealnmeal.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    private void createRestaurant (@RequestBody String restaurantJson) {
        log.info("Creating restaurant: {}", restaurantJson);
        JSONObject jsonObject = JSONObject.fromObject(restaurantJson);
        restaurantService.saveRestaurant(jsonObject);
    }

}
