package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.ItemDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("categories/{categoryId}/items")
public interface ItemResource {

    @PostMapping
    @ApiOperation(value = "Add an item")
    List<ItemDto> addItem(@PathVariable("categoryId") String categoryId,
            @RequestBody List<ItemDto> itemDtoList);
}
