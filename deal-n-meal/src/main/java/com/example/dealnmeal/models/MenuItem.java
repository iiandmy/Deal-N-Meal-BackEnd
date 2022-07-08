package com.example.dealnmeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "menu_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_item_id")
    private Long menuItemId;

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "menu_item_name")
    private String menuItemName;

    @Column(name = "menu_item_description")
    private String menuItemDescription;

    @Column(name = "menu_item_price")
    private Double menuItemPrice;

    @Column(name = "menu_item_weight")
    private Double menuItemWeight;
}
