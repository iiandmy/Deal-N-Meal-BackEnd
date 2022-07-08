package com.example.dealnmeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "restaurant_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantMenu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long menuId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "menu_type")
    private String menuType;

    @OneToMany
    @JoinColumn(name = "menu_id")
    private Collection<MenuItem> menuItems;
}
