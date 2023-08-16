package com.example.demo.dao;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    private String restaurantName;

    private double rating;

    @OneToMany(mappedBy = "restaurant")
    private Set<FoodRestaurant> foodRestaurants = new HashSet<>();

}
