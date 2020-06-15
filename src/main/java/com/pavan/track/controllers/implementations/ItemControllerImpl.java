package com.pavan.track.controllers.implementations;

import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.controllers.interfaces.CategoryController;
import com.pavan.track.controllers.interfaces.ItemController;
import com.pavan.track.entities.Category;
import com.pavan.track.entities.Item;
import com.pavan.track.exceptions.CategoryNotFoundException;
import com.pavan.track.models.dto.ItemDto;
import com.pavan.track.repositories.ItemRepository;
import com.pavan.track.services.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Validated
public class ItemControllerImpl implements ItemController {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    private final CategoryController categoryController;

    @Autowired
    public ItemControllerImpl(ItemRepository itemRepository, ItemMapper itemMapper, CategoryController categoryController) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.categoryController = categoryController;
    }

    @Override
    public List<ItemDto> addItem(
                    @NotNullOrBlank(message = "Category Id cannot be blank")
                    String categoryId,
                    @NotEmpty(message = "Item list cannot be empty")
                    List<@Valid ItemDto> itemDtoList) {

        Category category = categoryController.findByCategoryId(categoryId);

        List<Item> items =
                itemDtoList.stream().map(e -> {
                    Item item = itemMapper.mapToEntity(e);
                    item.setCategory(category);
                    return item;
                }).collect(Collectors.toList());

        return itemMapper.mapListToDto(
                itemRepository.saveAll(items)
            );
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return null;
    }

    @Override
    public Item getItemByItemName(
                    @NotNullOrBlank(message = "Item name cannot be empty")
                    String itemName) {
        return itemRepository.findByItemName(itemName);
    }
}
