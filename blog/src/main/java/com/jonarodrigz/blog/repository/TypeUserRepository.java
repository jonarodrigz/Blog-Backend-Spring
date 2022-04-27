package com.jonarodrigz.blog.repository;

import com.jonarodrigz.blog.entities.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Integer> {
}
