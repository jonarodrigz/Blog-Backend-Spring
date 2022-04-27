package com.jonarodrigz.blog.controller;

import com.jonarodrigz.blog.entities.Post;
import com.jonarodrigz.blog.entities.TypeUser;
import com.jonarodrigz.blog.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/api/posts")
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @PostMapping("/api/posts")
    public Post create(Post post){
        return postRepository.save(post);
    }

    @PutMapping("/api/posts")
    public Post update(Post post){
        return postRepository.save(post);
    }

    @DeleteMapping("/api/posts/{id}")
    public String delete(@PathVariable Integer id){
        postRepository.deleteById(id);
        return "Se elimino¡¡¡¡¡";
    }
}
