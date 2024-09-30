package com.example.demo.controller;

import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TimesheetPageService;
import com.example.demo.service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
            // FIXME return not-found.html
            throw new NoSuchElementException();
        }
        model.addAttribute("timesheet", timesheetPageDtoOpt.get());
        return "timesheet-page.html";
    }
}
