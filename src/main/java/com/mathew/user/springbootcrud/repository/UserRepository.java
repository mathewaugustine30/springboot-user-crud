package com.mathew.user.springbootcrud.repository;

import com.mathew.user.springbootcrud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
