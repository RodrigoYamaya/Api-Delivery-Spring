package com.RodSolution.demo.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public record ClientRequestDto(
        @NotBlank(message = "Nome e obrigatorio")
        @Size(min = 2, message = "Nome deve ter pelo menos 2 caracteres")
        String name,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        String phone,

        @NotBlank(message = "Endereço é obrigatório")
        String address,
        Instant createdAt

) {
}
