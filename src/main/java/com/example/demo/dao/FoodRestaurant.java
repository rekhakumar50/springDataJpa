package com.example.demo.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "foods_restaurants")
public class FoodRestaurant {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private Double foodPrice;

}
