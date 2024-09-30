package com.example.demo.controller;

import com.example.demo.models.Timesheet;
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

    private final TimesheetService timesheetService;

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable  Long id, Model model){
        Optional<Timesheet> timesheetOpt = timesheetService.get(id);
        if (timesheetOpt.isEmpty()){
            //FIXME вернуть страницу
            throw new NoSuchElementException();
        }
        Timesheet timesheet = timesheetOpt.get();
        model.addAttribute("timesheetId", timesheet.getId());
        model.addAttribute("timesheetMinutes", timesheet.getMinutes());
        model.addAttribute("timesheetCreateAt", timesheet.getCreateAt());
        return "timesheet-page.html";
    }
}
