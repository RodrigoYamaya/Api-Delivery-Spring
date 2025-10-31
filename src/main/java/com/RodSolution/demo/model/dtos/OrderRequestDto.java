package com.RodSolution.demo.model.dtos;

import com.RodSolution.demo.model.enums.OrderStatus;

import java.time.Instant;

public record OrderRequestDto(
        Instant moment,
        OrderStatus orderStatus,
        Long clientId
) {
}
