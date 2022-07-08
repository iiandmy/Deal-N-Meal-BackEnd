package com.example.dealnmeal.models;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long roleId;

    @Column(name = "name")
    private String name;
}
