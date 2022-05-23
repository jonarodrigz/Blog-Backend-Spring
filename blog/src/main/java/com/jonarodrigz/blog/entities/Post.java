package com.jonarodrigz.blog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="post" ,catalog="blog1")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String brief;
    private String content;
    private String image;
    private Date createdAt;
    private Integer status;

    private String author;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, mappedBy="post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(Category category, User user, String title, String brief, String content, String image, Date createdAt, Integer status, List<Comment> comments) {
        this.category = category;
        this.user = user;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
        this.status = status;
        this.comments = comments;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAuthor() {
        return user.getName();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id_post=" + id_post +
                ", category=" + category +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", comments=" + comments +
                '}';
    }
}
