package com.jonarodrigz.blog.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user1" ,catalog="blog1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "type_user")
     private TypeUser typeuser;

    private String name;

    private String lastname;

    private String username;

    private String email;

    private String password;

    private String image;

    private Integer status;

    private String tipoUsuario;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(TypeUser typeuser, String name, String lastname, String username, String email, String password, String image, Integer status) {
       this.typeuser = typeuser;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = image;
        this.status = status;
    }

    public Integer getId_user() {
        return iduser;
    }

    public void setId_user(Integer id_user) {
        this.iduser = id_user;
    }

       public TypeUser getTypeuser() {
        return typeuser;
    }

    public void setTypeuser(TypeUser typeuser) {
        this.typeuser = typeuser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTipoUsuario() {
        return this.typeuser.getName();
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + iduser +
                "typeuser=" + typeuser +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }
}
