package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.ItemDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("categories/{categoryId}/items")
public interface ItemResource {

    @PostMapping
    @Operation(summary = "Creates a new Item for given category Id")
    List<ItemDto> addItem(@PathVariable("categoryId") String categoryId,
            @RequestBody List<ItemDto> itemDtoList);
}
