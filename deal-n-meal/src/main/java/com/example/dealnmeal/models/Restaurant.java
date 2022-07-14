package com.example.dealnmeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_description")
    private String restaurantDescription;

    @Column(name = "restaurant_address")
    private String restaurantAddress;

    @Column(name = "restaurant_phone")
    private String restaurantPhone;

    @Column(name = "restaurant_email")
    private String restaurantEmail;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "restaurants_tags",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Collection<RestaurantTag> tags = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private Collection<RestaurantMenu> restaurantMenus;
}
