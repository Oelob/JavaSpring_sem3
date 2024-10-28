package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "users_roles")
@Data
public class UserRole {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (name = "user_id")
    private String userId;

    @Column (name = "role_id")
    private String roleId;

    @Column (name = "role_name")
    private String roleName;


}
