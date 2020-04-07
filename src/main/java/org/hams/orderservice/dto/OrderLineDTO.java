package org.hams.orderservice.dto;

import org.hams.orderservice.domain.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class OrderLineDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long orderLineId;
	// Fix for jacson infinite recursion
	// Else Jacson generates recursive json data
	@JsonBackReference
	private Order order;
	private Long itemId;
	private Double qty;

	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "OrderLineDTO [orderLineId=" + orderLineId + ", itemId=" + itemId + ", qty=" + qty + "]";
	}

}
