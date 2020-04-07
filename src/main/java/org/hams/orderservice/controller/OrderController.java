package org.hams.orderservice.controller;

import java.util.List;

import org.hams.orderservice.domain.Order;
import org.hams.orderservice.dto.OrderDTO;
import org.hams.orderservice.enums.OrderStatus;
import org.hams.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> getOrders() {
		ResponseEntity<List<OrderDTO>> responseEntity = orderService.getOrders();
		return responseEntity;
	}
	
	@GetMapping(path = "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Long id) {
		ResponseEntity<OrderDTO> responseEntity = orderService.getOrder(id);
		return responseEntity;
	}

	@PostMapping(path = "/")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
		ResponseEntity<OrderDTO> responseEntity = orderService.save(orderDTO);
		return responseEntity;
	}
	
	@PatchMapping(path = "/{id}/paymentStatus/{paymentStatus}")
	public ResponseEntity<OrderDTO> updatePaymentStatus(@PathVariable("id") Long id,@PathVariable("paymentStatus") String paymentStatus) {
		ResponseEntity<OrderDTO> responseEntity = orderService.updateOrderPaymentStatus(id,paymentStatus);
		return responseEntity;
	} 
}
