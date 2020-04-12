package com.pavan.track.controllers.interfaces;

import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.models.dto.ItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ItemController {

    List<ItemDto> addItem(
            @NotNullOrBlank(message = "Category Id cannot be blank")
            String categoryId,
            @NotEmpty(message = "Item list cannot be empty")
            List<@Valid ItemDto> itemDtoList);

    List<ItemDto> getAllItems();
}
