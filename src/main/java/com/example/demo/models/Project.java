package com.example.demo.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Project {
    private Long id;
    private String name;

}
