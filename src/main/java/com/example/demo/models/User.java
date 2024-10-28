package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "users")
@Data
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;
}
