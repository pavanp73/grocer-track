package com.pavan.track.services.mapper;

import com.pavan.track.entities.Order;
import com.pavan.track.models.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public OrderResponseDto mapToDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId().toString());
        orderResponseDto.setOrderDate(order.getOrderDate().toString());
        orderResponseDto.setItemName(order.getItem().getItemName());
        orderResponseDto.setCategoryName(order.getItem().getCategory().getCategoryName());
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setWeight(order.getWeight() + " " + order.getUnits());
        orderResponseDto.setStoreName(order.getStoreName());
        return orderResponseDto;
    }
}
