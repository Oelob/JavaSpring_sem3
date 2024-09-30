package com.example.demo.controller;

import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TimesheetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

//    private static Long sequence = 1l;
//    private final List<Timesheet> timesheets = new ArrayList<>();

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById (@PathVariable Long id){
        Optional<Project> ts = projectService.getById(id);
        if (ts.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<Project>> getAll (){
      return ResponseEntity.ok(projectService.getAll());
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project){
        project = projectService.create(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
