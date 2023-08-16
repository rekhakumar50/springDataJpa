package com.example.demo.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String orderNumber;
	private int totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_address_id", referencedColumnName = "id")
	private Address address;
	
	/*
	 * Used for OneToMany unidirectional mapping
	 * @OneToMany(cascade = CascadeType.ALL)
	 * @JoinColumn(name = "order_id", referencedColumnName = "id") 
	 * private Set<OrderItem> orderItems = new HashSet<>();
	 */
	
	//used for OneToMany bidirectional mapping
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Set<OrderItem> orderItems = new HashSet<>();
	
}
