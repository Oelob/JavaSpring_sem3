package com.example.demo.service;

import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.Timesheetrepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Project> get (Long id){
      return projectRepository.get(id);
    }

    public List<Project> getAll (){
        return projectRepository.getAll();
    }


    public Project create(Project project){
        return projectRepository.create(project);
    }


    public void delete (Long id) {
        projectRepository.delete(id);
    }
}
