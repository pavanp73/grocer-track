package com.pavan.track.apis.implementations;

import com.pavan.track.controllers.interfaces.ItemController;
import com.pavan.track.models.dto.ItemDto;
import com.pavan.track.apis.interfaces.ItemResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemResourceImpl implements ItemResource {

    private final ItemController itemController;

    @Autowired
    public ItemResourceImpl(ItemController itemController) {
        this.itemController = itemController;
    }


    @Override
    public List<ItemDto> addItem(String categoryId, List<ItemDto> itemDtoList) {
        return itemController.addItem(categoryId, itemDtoList);
    }
}
