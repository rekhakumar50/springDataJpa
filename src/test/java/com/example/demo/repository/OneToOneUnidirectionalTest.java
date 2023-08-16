package com.example.demo.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.Address;
import com.example.demo.dao.Order;

@SpringBootTest
public class OneToOneUnidirectionalTest {
	
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
		
		Order order = new Order();
		order.setOrderNumber("100ABC");
		order.setTotalQuantity(2);
		order.setTotalPrice(new BigDecimal(1000));
		order.setStatus("in-progress");
		order.setAddress(address);
		
		orderRepository.save(order);
	}
	
	
	@Test
	public void getOrder() {
		Order order = orderRepository.findById(4L).get();
		System.out.println(order);
	}
	
	
	@Test
	public void updateOrder() {
		Order order = orderRepository.findById(4L).get();
		order.setStatus("completed");
		order.getAddress().setPincode("pincode1");
		
		orderRepository.save(order);
	}
	
	
	@Test
	public void deleteOrder() {
		orderRepository.deleteById(4L);
	}
}
