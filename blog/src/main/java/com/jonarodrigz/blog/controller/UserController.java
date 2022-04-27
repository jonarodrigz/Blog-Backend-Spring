package com.jonarodrigz.blog.controller;

import com.jonarodrigz.blog.entities.TypeUser;
import com.jonarodrigz.blog.entities.User;
import com.jonarodrigz.blog.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/users")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> findOneById(@PathVariable Integer id){

        Optional<User> userOpt = userRepository.findById(id);
        // opcion 1
        if(userOpt.isPresent())
            return ResponseEntity.ok(userOpt.get());
        else
            return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/users")
    public User create(User user){
        return userRepository.save(user);
    }

    @PutMapping("/api/users")
    public User update(User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/api/users/{id}")
    public String delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return "Se elimino¡¡¡¡¡";
    }
}
