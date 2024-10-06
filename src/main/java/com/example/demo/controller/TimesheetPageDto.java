package com.example.demo.controller;

import lombok.Data;

@Data
public class TimesheetPageDto {
        private String projectName;
        private String id;
        private String minutes;
        private String createAt;
        private String projectId;
}
