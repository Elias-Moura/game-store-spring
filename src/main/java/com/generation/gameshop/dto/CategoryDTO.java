package com.generation.gameshop.dto;

import com.generation.gameshop.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        @NotNull
        Long id,
        @NotBlank(message = "O campo 'name' é obrigatório.")
        @Size(min = 2, max = 100, message = "O campo 'name' não deve conter entre 2 a 100 caracteres.")
        String name
) {

        public CategoryDTO(Category category) {
                this(category.getId(), category.getName());
        }

}
