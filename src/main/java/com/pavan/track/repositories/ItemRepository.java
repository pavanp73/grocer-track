package com.pavan.track.repositories;

import com.pavan.track.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    Item findByItemName(String itemName);
}
