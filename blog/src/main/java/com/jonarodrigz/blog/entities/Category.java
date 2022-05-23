package com.jonarodrigz.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category" ,catalog="blog1")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_category;
    private String name;
    private String detail;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy="category", cascade = CascadeType.ALL)
    private List<Post> posts;

    public Category() {
    }

    public Category(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
