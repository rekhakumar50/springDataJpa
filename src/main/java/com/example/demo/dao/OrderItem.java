package com.example.demo.dao;

import java.math.BigDecimal;

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
@Table(name = "order_items")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String imageUrl;
	private BigDecimal price;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

}
