package com.pavan.track.services.mapper;

import com.pavan.track.entities.Item;
import com.pavan.track.models.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemMapper {

    public Item mapToEntity(ItemDto itemDto){
      Item item = new Item();
      item.setItemName(itemDto.getItemName());
      item.setUnitType(itemDto.getUnitType());
      return item;
    }


    public ItemDto mapToDto(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId().toString());
        itemDto.setItemName(item.getItemName());
        itemDto.setUnitType(item.getUnitType());
        return itemDto;
    }


    public List<ItemDto> mapListToDto(List<Item> items){
        return items.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
