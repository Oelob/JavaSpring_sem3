package com.example.demo.controller;

import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TimesheetPageService;
import com.example.demo.service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetPageController {

    private final TimesheetPageService timesheetPageService;

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable  Long id, Model model){
        Optional<TimesheetPageDto> timesheetPageDtoOpt = timesheetPageService.getById(id);
        if (timesheetPageDtoOpt.isEmpty()){
            return "not-found.html";
        }
        model.addAttribute("timesheet", timesheetPageDtoOpt.get());
        return "timesheet-page.html";
    }

    @GetMapping
    public String getAllTimesheets(Model model){
        List<TimesheetPageDto> timesheets = timesheetPageService.findAll();
        model.addAttribute("timesheets", timesheets);
        return "timesheets-page.html";
    }


}
