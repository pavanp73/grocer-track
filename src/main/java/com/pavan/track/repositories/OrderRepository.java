package com.pavan.track.repositories;

import com.pavan.track.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByOrderDateBetween(LocalDate orderDateStart, LocalDate orderDateEnd);
}
