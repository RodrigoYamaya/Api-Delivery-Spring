package com.RodSolution.demo.model.dtos;

import com.RodSolution.demo.model.enums.OrderStatus;

import java.time.Instant;

public record OrderResponseDto(
        Long id,
        Instant moment,
        OrderStatus orderStatus,
        String clientName,
        String clientEmail
) {

}

