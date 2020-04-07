package org.hams.orderservice.enums;

public enum OrderStatus {

	CREATED("Created"), PAYMENT_FAILED("Payment Failed"), CONFIRMED("Confirmed"), SHIPPED("Shipped"), CANCELLED(
			"Cancelled");
	final private String value;

	private OrderStatus(String value) {
		System.out.println("In OrderStatus: " + value);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
