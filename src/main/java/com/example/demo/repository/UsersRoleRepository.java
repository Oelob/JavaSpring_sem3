package com.example.demo.repository;

import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRoleRepository extends JpaRepository <UserRole, Long> {
    @Query(nativeQuery = true, value = "select role_id from users_roles ur where ur.user_id = :userId")
    List<String> findUserRolesByUserId(Long userId);
}
