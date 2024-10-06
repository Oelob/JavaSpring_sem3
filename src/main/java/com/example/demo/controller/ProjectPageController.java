package com.example.demo.controller;

import com.example.demo.service.ProjectPageService;
import com.example.demo.service.TimesheetPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home/projects")
@RequiredArgsConstructor
public class ProjectPageController {

    private final ProjectPageService projectPageService;

    @GetMapping("/{id}")
    public String getProjectPage(@PathVariable Long id, Model model){
        Optional<ProjectDTO> projectDTOOpt = projectPageService.getById(id);
        if (projectDTOOpt.isEmpty()){
            return "not-found.html";
        }
        model.addAttribute("project", projectDTOOpt.get());
        return "project-page.html";
    }

    @GetMapping
    public String getAllProjects(Model model){
        List<ProjectDTO> projects = projectPageService.findAll();
        model.addAttribute("projects", projects);
        return "projects-page.html";
    }

}
