package com.example.dealnmeal.DAO;

import com.example.dealnmeal.models.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMenuDAO extends JpaRepository<RestaurantMenu, Long> {

}
