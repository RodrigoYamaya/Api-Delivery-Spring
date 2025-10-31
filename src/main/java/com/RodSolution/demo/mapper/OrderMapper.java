package com.RodSolution.demo.mapper;

import com.RodSolution.demo.model.dtos.OrderRequestDto;
import com.RodSolution.demo.model.dtos.OrderResponseDto;

import com.RodSolution.demo.model.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderRequestDto dto);

    OrderResponseDto toDto(Order entity);


}
