package com.RodSolution.demo.repositories;

import com.RodSolution.demo.model.entities.Order;
import com.RodSolution.demo.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClienteId(Long clienteId);

    List<Order> findByStatus(OrderStatus status);

    List<Order> findByMomentBetween(Instant inicio, Instant fim);
}
