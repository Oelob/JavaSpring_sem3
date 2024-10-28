package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table (name = "roles_table")
@Data
public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (name = "name")
    private String name;

}
