package com.pavan.track.controllers.implementations;

import com.pavan.track.controllers.interfaces.ItemController;
import com.pavan.track.controllers.interfaces.OrderController;
import com.pavan.track.entities.Item;
import com.pavan.track.entities.Order;
import com.pavan.track.models.dto.OrderRequestDto;
import com.pavan.track.models.dto.OrderResponseDto;
import com.pavan.track.repositories.OrderRepository;
import com.pavan.track.services.mapper.OrderMapper;
import com.pavan.track.services.utils.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Controller
@Validated
public class OrderControllerImpl implements OrderController {

    private final OrderRepository orderRepository;

    private final ItemController itemController;

    private final OrderMapper orderMapper;

    @Autowired
    public OrderControllerImpl(OrderRepository orderRepository,
                               ItemController itemController,
                               OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.itemController = itemController;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponseDto addOrder(@Valid OrderRequestDto orderRequestDto) {

        Item item = itemController.getItemByItemName(orderRequestDto.getItemName());
        Order order = new Order();
        order.setOrderDate(DateUtility.convertToDate(orderRequestDto.getOrderDate()));
        order.setPrice(orderRequestDto.getPrice());
        order.setUnits(orderRequestDto.getUnits());
        order.setWeight(orderRequestDto.getWeight());
        order.setItem(item);
        return orderMapper.mapToDto(
                orderRepository.save(order)
        );
    }
}
