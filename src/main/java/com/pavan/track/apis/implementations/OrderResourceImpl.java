package com.pavan.track.apis.implementations;

import com.pavan.track.apis.interfaces.OrderResource;
import com.pavan.track.controllers.interfaces.OrderController;
import com.pavan.track.models.dto.OrderRequestDto;
import com.pavan.track.models.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderResourceImpl implements OrderResource {

    private final OrderController orderController;

    @Autowired
    public OrderResourceImpl(OrderController orderController) {
        this.orderController = orderController;
    }

    @Override
    public OrderResponseDto addOrder(OrderRequestDto orderRequestDto) {
        return orderController.addOrder(orderRequestDto);
    }
}
