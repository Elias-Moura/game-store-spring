package com.generation.gameshop.model;

import com.generation.gameshop.dto.CategoryDTO;
import com.generation.gameshop.dto.CreateCategoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_categories")
@Table(name = "tb_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;
    private Timestamp deleted_at;

    public Category(CreateCategoryDTO data){
        this.active = true;
        this.name = data.name();
    }

    public Category(CategoryDTO data){
        this.id = data.id();
        this.name = data.name();
    }

    public void delete(){
        this.active = false;
        this.deleted_at = Timestamp.valueOf(LocalDateTime.now());
    }
}
