package com.example.dealnmeal.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Data
public class RestaurantTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_name")
    private String tagName;
}
