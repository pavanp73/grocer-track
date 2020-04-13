package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.OrderRequestDto;
import com.pavan.track.models.dto.OrderResponseDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("orders")
public interface OrderResource {

    @PostMapping
    @ApiOperation(value = "Add an order")
    OrderResponseDto addOrder(@RequestBody OrderRequestDto orderRequestDto);

}
