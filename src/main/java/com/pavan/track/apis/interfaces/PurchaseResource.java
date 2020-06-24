package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.PurchaseRequestDto;
import com.pavan.track.models.dto.PurchaseResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("purchases")
public interface PurchaseResource {

    @PostMapping
    @Operation(summary = "Creates a new purchase")
    PurchaseResponseDto addPurchase(@RequestBody PurchaseRequestDto purchaseRequestDto);

    @GetMapping
    @Operation(summary = "Get list of Purchases")
    List<PurchaseResponseDto> getPurchases();
}
