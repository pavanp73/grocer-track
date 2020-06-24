package com.pavan.track.repositories;

import com.pavan.track.entities.Purchase;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID>, JpaSpecificationExecutor<Purchase> {

    List<Purchase> findAllByPurchaseDateBetween(LocalDate purchaseDateStart, LocalDate purchaseDateEnd);
}
