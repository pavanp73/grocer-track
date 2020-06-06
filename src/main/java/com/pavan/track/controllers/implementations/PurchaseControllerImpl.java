package com.pavan.track.controllers.implementations;

import com.pavan.track.controllers.interfaces.ItemController;
import com.pavan.track.controllers.interfaces.PurchaseController;
import com.pavan.track.entities.Item;
import com.pavan.track.entities.Purchase;
import com.pavan.track.models.dto.PurchaseRequestDto;
import com.pavan.track.models.dto.PurchaseResponseDto;
import com.pavan.track.repositories.PurchaseRepository;
import com.pavan.track.services.mapper.PurchaseMapper;
import com.pavan.track.services.utils.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Controller
@Validated
public class PurchaseControllerImpl implements PurchaseController {

    private final PurchaseRepository purchaseRepository;

    private final ItemController itemController;

    private final PurchaseMapper purchaseMapper;

    @Autowired
    public PurchaseControllerImpl(PurchaseRepository purchaseRepository,
                                  ItemController itemController,
                                  PurchaseMapper purchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.itemController = itemController;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public PurchaseResponseDto addPurchase(@Valid PurchaseRequestDto purchaseRequestDto) {

        Item item = itemController.getItemByItemName(purchaseRequestDto.getItemName());
        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(DateUtility.convertToDate(purchaseRequestDto.getPurchaseDate()));
        purchase.setPrice(purchaseRequestDto.getPrice());
        purchase.setUnits(purchaseRequestDto.getUnits());
        purchase.setWeight(purchaseRequestDto.getWeight());
        purchase.setItem(item);
        purchase.setStoreName(purchaseRequestDto.getStoreName());
        return purchaseMapper.mapToDto(
                purchaseRepository.save(purchase)
        );
    }
}
