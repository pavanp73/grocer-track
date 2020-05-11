package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.OrderRequestDto;
import com.pavan.track.models.dto.OrderResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("orders")
public interface OrderResource {

    @PostMapping
    @Operation(summary = "Creates a new order")
    OrderResponseDto addOrder(@RequestBody OrderRequestDto orderRequestDto);

}
