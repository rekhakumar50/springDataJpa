package com.example.demo.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.Address;
import com.example.demo.dao.Order;
import com.example.demo.dao.OrderItem;

@SpringBootTest
public class OneToManyUnidirectionalTest {

	@Autowired
	private OrderRepository orderRepository;

	
	@Test
	public void saveOrder() {
		Address address = new Address();
		address.setStreet("street");
		address.setCity("city");
		address.setState("state");
		address.setCountry("country");
		address.setPincode("pincode");
		
		OrderItem orderitem1 = new OrderItem();
		orderitem1.setImageUrl("imageUrl1");
		orderitem1.setQuantity(2);
		orderitem1.setPrice(new BigDecimal(1000));
		
		OrderItem orderitem2 = new OrderItem();
		orderitem2.setImageUrl("imageUrl2");
		orderitem2.setQuantity(1);
		orderitem2.setPrice(new BigDecimal(700));
				
		Order order = new Order();
		order.setOrderNumber("100ABC");
		order.setTotalQuantity(2);
		order.setTotalPrice(new BigDecimal(1000));
		order.setStatus("in-progress");
		order.setAddress(address);
		order.getOrderItems().add(orderitem1);
		order.getOrderItems().add(orderitem2);
		
		orderRepository.save(order);
	}
	

	@Test
	public void getOrder() {
		Order order = orderRepository.findById(1L).get();
		System.out.println(order.getId());
	}
	
	
	@Test
	public void updateOrder() {
		Order order = orderRepository.findById(1L).get();
		order.setStatus("completed");
		order.getAddress().setPincode("pincode1");
		
		orderRepository.save(order);
	}
	
	
	@Test
	public void deleteOrder() {
		orderRepository.deleteById(1L);
	}
	
}
