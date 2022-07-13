package com.example.dealnmeal.DAO;

import com.example.dealnmeal.models.RestaurantTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTagsDAO extends JpaRepository<RestaurantTag, Long> {

}