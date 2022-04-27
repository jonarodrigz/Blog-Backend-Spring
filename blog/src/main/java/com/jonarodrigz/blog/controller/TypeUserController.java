package com.jonarodrigz.blog.controller;

import com.jonarodrigz.blog.entities.TypeUser;
import com.jonarodrigz.blog.repository.TypeUserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeUserController {

    private TypeUserRepository tpRepository;

    public TypeUserController(TypeUserRepository tpRepository) {
        this.tpRepository = tpRepository;
    }

    @GetMapping("/api/typeuser")
    public List<TypeUser> findAll(){
        return tpRepository.findAll();
    }

    @PostMapping(value = "/api/typeuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TypeUser create(@RequestBody TypeUser type){
        return tpRepository.save(type);
    }

    @PutMapping("/api/typeuser")
    public TypeUser update(TypeUser type){
        return tpRepository.save(type);
    }

    @DeleteMapping("/api/typeuser/{id}")
    public String delete(@PathVariable Integer id){
        tpRepository.deleteById(id);
        return "Se elimino¡¡¡¡¡";
    }
}
