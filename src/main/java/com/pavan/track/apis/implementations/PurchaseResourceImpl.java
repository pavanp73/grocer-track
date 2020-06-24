package com.pavan.track.apis.implementations;

import com.pavan.track.apis.interfaces.PurchaseResource;
import com.pavan.track.controllers.interfaces.PurchaseController;
import com.pavan.track.models.dto.PurchaseRequestDto;
import com.pavan.track.models.dto.PurchaseResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseResourceImpl implements PurchaseResource {

    private final PurchaseController purchaseController;

    @Autowired
    public PurchaseResourceImpl(PurchaseController purchaseController) {
        this.purchaseController = purchaseController;
    }

    @Override
    public PurchaseResponseDto addPurchase(PurchaseRequestDto purchaseRequestDto) {
        return purchaseController.addPurchase(purchaseRequestDto);
    }

    @Override
    public List<PurchaseResponseDto> getPurchases() {
        return purchaseController.getPurchases("Water Can");
    }
}
