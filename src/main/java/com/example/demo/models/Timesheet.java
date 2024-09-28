package com.example.demo.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Timesheet {
    private Long id;
    private Long projectId;
    private int minutes;
    private LocalDate createAt;

    public Timesheet(Long id, Long projectId, int minutes, LocalDate createAt) {
        this.id = id;
        this.projectId = projectId;
        this.minutes = minutes;
        this.createAt = createAt;
    }

}
