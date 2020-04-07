package org.hams.orderservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hams.orderservice.domain.Order;
import org.hams.orderservice.dto.OrderDTO;
import org.hams.orderservice.enums.OrderStatus;
import org.hams.orderservice.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Transactional
	public ResponseEntity<OrderDTO> getOrder(Long id) {
		OrderDTO orderDTO = null;
		Optional<Order> optional = orderRepo.findById(id);
		Order order = optional.isPresent() ? optional.get() : null;
		if (order != null)
			orderDTO = modelMapper.map(order, OrderDTO.class);
		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
	}


	@Transactional
	public ResponseEntity<OrderDTO> save(OrderDTO orderDTO) {
		OrderDTO returnODTO = null;
		Order order = modelMapper.map(orderDTO, Order.class);
		order.setOrderStatus(OrderStatus.CREATED);
		Order save = orderRepo.save(order);
		if (save != null)
			returnODTO = modelMapper.map(save, OrderDTO.class);
		return new ResponseEntity<>(returnODTO, HttpStatus.CREATED);
	}

	@Transactional
	public ResponseEntity<List<OrderDTO>> getOrders() {
		List<Order> findAll = orderRepo.findAll();
		List<OrderDTO> orderDTOs = modelMapper.map(findAll, new TypeToken<List<OrderDTO>>() {}.getType());
		return new ResponseEntity<>(orderDTOs, HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<OrderDTO> updateOrderPaymentStatus(Long id, String paymentStatus) {
		OrderStatus orderStatus = OrderStatus.valueOf(paymentStatus);
		Optional<Order> optional = orderRepo.findById(id);
		Order order = optional.isPresent() ? optional.get() : null;
		order.setOrderStatus(orderStatus);
		Order updatedOrder = orderRepo.save(order);
		OrderDTO orderDTO = modelMapper.map(updatedOrder, OrderDTO.class);
		return new ResponseEntity<>(orderDTO,HttpStatus.OK);
	}

}
