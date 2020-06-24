package com.pavan.track.services.mapper;

import com.pavan.track.entities.Purchase;
import com.pavan.track.models.dto.PurchaseResponseDto;
import com.pavan.track.services.utils.MathUtility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseMapper {

    public PurchaseResponseDto mapToDto(Purchase purchase){
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setId(purchase.getId().toString());
        purchaseResponseDto.setPurchaseDate(purchase.getPurchaseDate().toString());
        purchaseResponseDto.setItemName(purchase.getItem().getItemName());
        purchaseResponseDto.setCategoryName(purchase.getItem().getCategory().getCategoryName());
        purchaseResponseDto.setPrice(MathUtility.twoDecimalRoundOff(purchase.getPrice()));
        purchaseResponseDto.setWeight(MathUtility.twoDecimalRoundOff(purchase.getWeight()) + " " + purchase.getUnits());
        purchaseResponseDto.setStoreName(purchase.getStoreName());
        return purchaseResponseDto;
    }

    public List<PurchaseResponseDto> mapToDtoList(List<Purchase> purchases){
        return purchases.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
