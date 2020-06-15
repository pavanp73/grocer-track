package com.pavan.track.repositories;

import com.pavan.track.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

    List<Purchase> findAllByPurchaseDateBetween(LocalDate purchaseDateStart, LocalDate purchaseDateEnd);
}
