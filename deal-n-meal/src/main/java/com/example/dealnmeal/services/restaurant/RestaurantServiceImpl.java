package com.example.dealnmeal.services.restaurant;

import com.example.dealnmeal.DAO.RestaurantDAO;
import com.example.dealnmeal.DAO.RestaurantTagsDAO;
import com.example.dealnmeal.models.Restaurant;
import com.example.dealnmeal.models.RestaurantTag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDAO restaurantDAO;
    private final RestaurantTagsDAO restaurantTagsDAO;

    @Override
    public Restaurant saveRestaurant(JSONObject restaurantJson) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantJson.getString("restaurantName"));
        restaurant.setRestaurantDescription(restaurantJson.getString("restaurantDescription"));
        restaurant.setRestaurantAddress(restaurantJson.getString("restaurantAddress"));
        restaurant.setRestaurantPhone(restaurantJson.getString("restaurantPhone"));
        restaurant.setRestaurantEmail(restaurantJson.getString("restaurantEmail"));
        JSONArray restaurantTagsJson = restaurantJson.getJSONArray("tags");
        restaurantTagsJson.forEach(tag -> {
            RestaurantTag restaurantTag = new RestaurantTag(null, tag.toString());
            restaurantTagsDAO.save(restaurantTag);
            restaurant.getTags().add(restaurantTag);
        });

        return restaurantDAO.save(restaurant);
    }
}
