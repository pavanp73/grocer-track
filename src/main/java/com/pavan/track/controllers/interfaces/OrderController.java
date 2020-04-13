package com.pavan.track.controllers.interfaces;

import com.pavan.track.models.dto.OrderRequestDto;
import com.pavan.track.models.dto.OrderResponseDto;

import javax.validation.Valid;

public interface OrderController {

    OrderResponseDto addOrder(@Valid OrderRequestDto orderRequestDto);
}
