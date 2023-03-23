package com.example.simplerestapi.repository;

import com.example.simplerestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
        Boolean existsByName(String name);
}
