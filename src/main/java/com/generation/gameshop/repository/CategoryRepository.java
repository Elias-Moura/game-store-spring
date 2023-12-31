package com.generation.gameshop.repository;

import com.generation.gameshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByNameContainingIgnoreCaseAndActiveTrue(@Param("name") String name);
    List<Category> findAllByActiveTrue();
    Optional<Category> findByIdAndActiveTrue(@Param("id") Long id);
    Boolean existsByIdAndActiveTrue(@Param("id") Long id);
}
