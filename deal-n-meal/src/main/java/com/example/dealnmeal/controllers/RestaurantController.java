package com.example.dealnmeal.controllers;

import com.example.dealnmeal.models.Restaurant;
import com.example.dealnmeal.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    private void createRestaurant (@RequestBody String restaurantJson) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/create").toUriString());
        log.info("Creating restaurant: {}", restaurantJson);
        restaurantService.saveRestaurant(restaurantJson);
    }

}
