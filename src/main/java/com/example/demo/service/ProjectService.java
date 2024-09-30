package com.example.demo.service;

import com.example.demo.models.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Project> getById (Long id){
      return projectRepository.getById(id);
    }

    public Optional<Project> getByName (String name){
      return projectRepository.getByName(name);
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
