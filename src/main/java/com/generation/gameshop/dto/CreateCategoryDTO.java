package com.generation.gameshop.dto;

import com.generation.gameshop.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryDTO(
        @NotBlank(message = "O campo 'name' é obrigatório.")
        @Size(min = 2, max = 100, message = "O campo 'name' não deve conter entre 2 a 100 caracteres.")
        String name) {

    CreateCategoryDTO(Category data) {
        this(data.getName());
    }
}
