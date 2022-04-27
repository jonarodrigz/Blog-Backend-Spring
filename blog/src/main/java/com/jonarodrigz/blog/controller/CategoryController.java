package com.jonarodrigz.blog.controller;

import com.jonarodrigz.blog.entities.Category;
import com.jonarodrigz.blog.entities.Comment;
import com.jonarodrigz.blog.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryRepository cRepository;

    public CategoryController(CategoryRepository cRepository) {
        this.cRepository = cRepository;
    }

    @GetMapping("/api/category")
    public List<Category> findAll(){
        return  cRepository.findAll();
    }

    @PostMapping("/api/category")
    public Category create(Category category){
        return cRepository.save(category);
    }

    @PutMapping("/api/category")
    public Category update(Category category){
        return cRepository.save(category);
    }

    @DeleteMapping("/api/category/{id}")
    public String delete(@PathVariable Integer id){
        cRepository.deleteById(id);
        return "Se elimino¡¡¡¡¡";
    }
}
