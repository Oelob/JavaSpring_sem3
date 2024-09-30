package com.example.demo.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Timesheet {
    private Long id;
    private String projectName;
    private int minutes;
    private LocalDate createAt;

    public Timesheet(Long id, String projectName, int minutes, LocalDate createAt) {
        this.id = id;
        this.projectName = projectName;
        this.minutes = minutes;
        this.createAt = createAt;
    }

    public Timesheet() {
    }
}
