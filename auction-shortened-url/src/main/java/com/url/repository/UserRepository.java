package com.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.url.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
