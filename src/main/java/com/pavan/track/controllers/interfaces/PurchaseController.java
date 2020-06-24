package com.pavan.track.controllers.interfaces;

import com.pavan.track.models.dto.PurchaseRequestDto;
import com.pavan.track.models.dto.PurchaseResponseDto;

import javax.validation.Valid;
import java.util.List;

public interface PurchaseController {

    PurchaseResponseDto addPurchase(@Valid PurchaseRequestDto purchaseRequestDto);

    List<PurchaseResponseDto> getPurchases(String categoryName);
}
