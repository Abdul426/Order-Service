package org.hams.orderservice.dto;

import java.util.Date;
import java.util.List;

import org.hams.orderservice.enums.OrderStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class OrderDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long orderId;
	private Long customerId;
	private Date createdOn;
	private Date updatedOn;
	private Date deliveredOn;
	private List<OrderLineDTO> orderLines;
	@JsonProperty(access = Access.READ_ONLY)
	private OrderStatus orderStatus;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Date getDeliveredOn() {
		return deliveredOn;
	}

	public void setDeliveredOn(Date deliveredOn) {
		this.deliveredOn = deliveredOn;
	}

	public List<OrderLineDTO> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLineDTO> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", customerId=" + customerId + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", deliveredOn=" + deliveredOn + ", orderLines=" + orderLines
				+ ", orderStatus=" + orderStatus + "]";
	}

}
