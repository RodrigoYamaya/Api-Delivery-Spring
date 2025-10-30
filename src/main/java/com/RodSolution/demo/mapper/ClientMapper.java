package com.RodSolution.demo.mapper;

import com.RodSolution.demo.model.dtos.ClientRequestDto;
import com.RodSolution.demo.model.dtos.ClientResponseDto;
import com.RodSolution.demo.model.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientRequestDto dto);

    ClientResponseDto toDto(Client entity);


}
