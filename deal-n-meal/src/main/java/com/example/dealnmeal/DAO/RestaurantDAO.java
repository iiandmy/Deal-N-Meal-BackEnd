package com.example.dealnmeal.DAO;

import com.example.dealnmeal.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Long> {


}
