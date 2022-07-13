package com.example.dealnmeal.models;

import javax.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email")
    private String email;
    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "registration_date")
    private Date registrationDate;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}
