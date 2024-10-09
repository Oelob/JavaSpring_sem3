package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "timesheet")
public class Timesheet {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String projectName;
    private Integer minutes;
    private LocalDate createAt;
    private Long employeeId;

    public Timesheet(Long id, String projectName, int minutes, LocalDate createAt, Long employeeId) {
        this.id = id;
        this.projectName = projectName;
        this.minutes = minutes;
        this.createAt = createAt;
        this.employeeId = employeeId;
    }

    public Timesheet() {
    }
}
