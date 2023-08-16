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
@Table(name = "foods")
public class Food {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    private String foodName;

    @OneToMany(mappedBy = "food")
    private Set<FoodRestaurant> foodRestaurants = new HashSet<>();

}
