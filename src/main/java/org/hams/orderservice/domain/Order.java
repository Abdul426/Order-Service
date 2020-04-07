package org.hams.orderservice.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hams.orderservice.enums.OrderStatus;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private Long customerId;
	@Temporal(TemporalType.DATE)
	private Date createdOn;
	@Temporal(TemporalType.TIME)
	private Date updatedOn;
	@Temporal(TemporalType.TIME)
	private Date deliveredOn;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
	private Set<OrderLine> orderLines = new HashSet<>();

	@Convert(converter = OrderStatusConverter.class)
	//@Enumerated(EnumType.STRING) If you have this Converter don't work.
	private OrderStatus orderStatus;

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLine> orderLines) {
		// This is required to set th FK in OrderLine
		orderLines.forEach(orderLine -> orderLine.setOrder(this));
		this.orderLines = orderLines;
	}

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

	@PrePersist
	public void setCreatedOn() {
		this.createdOn = new Date();
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", deliveredOn=" + deliveredOn + ", orderLines=" + orderLines + ", orderStatus="
				+ orderStatus + "]";
	}

}
