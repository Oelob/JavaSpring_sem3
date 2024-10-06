package com.example.demo.service;

import com.example.demo.controller.TimesheetPageDto;
import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimesheetPageService {

    private final TimesheetService timesheetService;
    private final ProjectService projectService;
    public Optional<TimesheetPageDto> getById(Long id){
        return timesheetService.get(id)
                .map(this::convert);

    }

    private TimesheetPageDto convert(Timesheet timesheet){
        Project project = projectService.getByName(timesheet.getProjectName())
                .orElseThrow();

        TimesheetPageDto timesheetPageDto = new TimesheetPageDto();
        timesheetPageDto.setProjectName(project.getName());
        timesheetPageDto.setId(String.valueOf(timesheet.getId()));
        timesheetPageDto.setMinutes(String.valueOf(timesheet.getMinutes()));
        timesheetPageDto.setCreateAt(String.valueOf(timesheet.getCreateAt()));
        timesheetPageDto.setProjectId(String.valueOf(project.getId()));

        return timesheetPageDto;
    }
    public List<TimesheetPageDto> findAll(){
        return timesheetService.getAll().stream()
                .map(this::convert)
                .toList();
    }

}
