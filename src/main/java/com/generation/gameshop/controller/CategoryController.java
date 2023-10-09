package com.generation.gameshop.controller;

import com.generation.gameshop.dto.CategoryDTO;
import com.generation.gameshop.dto.CreateCategoryDTO;
import com.generation.gameshop.model.Category;
import com.generation.gameshop.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @PostMapping
    @Transactional //TODO: Corrigir 500 quando já existe uma categoria
    public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CreateCategoryDTO data) {
        var id = repository.save(new Category(data)).getId();
        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoryDTO(id, data.name()));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(@RequestParam(name = "name", required = false) String name) {
        List<Category> categories;

        if (name != null)
            categories = repository.findAllByNameContainingIgnoreCaseAndActiveTrue(name);
        else
            categories = repository.findAllByActiveTrue();

        return ResponseEntity.ok(categories.stream().map(CategoryDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Optional<Category> category = repository.findByIdAndActiveTrue(id);
        if (category.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não existe.");
        }
        CategoryDTO result = new CategoryDTO(category.get());
        return ResponseEntity.ok(result);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CategoryDTO> put(@RequestBody @Valid CategoryDTO category) {
        var exists = repository.existsByIdAndActiveTrue(category.id());

        if (!exists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.save(new Category(category));
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var exists = repository.existsByIdAndActiveTrue(id);

        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID não existe.");
        }
        var category = repository.getReferenceById(id);
        category.delete();
    }
}
