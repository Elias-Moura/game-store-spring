package com.generation.gameshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryData(
        @NotBlank(message = "O campo 'name' é obrigatório.")
        @Size(min = 2, max = 100, message = "O campo 'name' não deve conter entre 2 a 100 caracteres.")
        String name
) {
}
