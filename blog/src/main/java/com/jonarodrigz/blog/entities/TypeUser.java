package com.jonarodrigz.blog.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "typeuser", catalog = "blog")
public class TypeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idTypeuser")

    private int idTypeuser;

    private String name;

    private String detail;

  @JsonIgnore
   @OneToMany(fetch=FetchType.LAZY, mappedBy="typeuser", cascade = CascadeType.ALL)
    List<User> users = new ArrayList<>();


    public TypeUser() {
    }

    public TypeUser( String name, String detail) {
         this.name = name;
        this.detail = detail;
    }

    public Integer getIdTypeUser() {
        return idTypeuser;
    }

    public void setIdTypeUser(Integer idTypeUser) {
        this.idTypeuser = idTypeUser;
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


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TypeUser{" +
                "idTypeuser=" + idTypeuser +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
