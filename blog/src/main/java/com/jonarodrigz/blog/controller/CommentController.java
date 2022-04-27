package com.jonarodrigz.blog.controller;

import com.jonarodrigz.blog.entities.Comment;
import com.jonarodrigz.blog.entities.TypeUser;
import com.jonarodrigz.blog.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/api/comment")
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }
    @PostMapping("/api/comment")
    public Comment create(Comment comment){
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comment")
    public Comment update(Comment comment){
        return commentRepository.save(comment);
    }

    @DeleteMapping("/api/comment/{id}")
    public String delete(@PathVariable Integer id){
        commentRepository.deleteById(id);
        return "Se elimino¡¡¡¡¡";
    }
}
