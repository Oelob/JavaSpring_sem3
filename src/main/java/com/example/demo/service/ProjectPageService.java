package com.example.demo.service;

import com.example.demo.controller.ProjectDTO;
import com.example.demo.controller.TimesheetPageDto;
import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectPageService {

    private final ProjectService projectService;
    public Optional<ProjectDTO> getById(Long id){
        return projectService.getById(id)
                .map(this::convert);
    }

    private ProjectDTO convert(Project project){

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(String.valueOf(project.getId()));
        projectDTO.setName(project.getName());
        return projectDTO;
    }
    public List<ProjectDTO> findAll(){
        return projectService.getAll().stream()
                .map(this::convert)
                .toList();
    }

}
