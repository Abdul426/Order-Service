package org.hams.orderservice.domain;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.hams.orderservice.enums.OrderStatus;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

	@Override
	public String convertToDatabaseColumn(OrderStatus orderStatus) {
		System.out.println("In OrderStatusConverter::convertToDatabaseColumn: " + orderStatus);
		if (orderStatus == null)
			return null;
		String returnOS = orderStatus.getValue();
		return returnOS;
	}

	@Override
	public OrderStatus convertToEntityAttribute(String dbOrderStats) {
		System.out.println("In OrderStatusConverter::convertToEntityAttribute: " + dbOrderStats);
		if (dbOrderStats == null)
			return null;
		OrderStatus oStatusElseThrow = Stream.of(OrderStatus.values())
				.filter(orderStat -> orderStat.getValue().equals(dbOrderStats)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
		return oStatusElseThrow;
	}

}
