package com.example.demo.controller;

import com.example.demo.models.Timesheet;
import com.example.demo.service.TimesheetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController

public class TimesheetController {

    private final TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("/timesheets/{id}")
    public ResponseEntity<Timesheet> get (@PathVariable Long id){
        Optional<Timesheet> ts = timesheetService.get(id);
        if (ts.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/timesheets")
    public ResponseEntity<List<Timesheet>> getAll (){
      return ResponseEntity.ok(timesheetService.getAll());
    }

    @PostMapping("/timesheets")
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet){
        Optional<Timesheet> ts = timesheetService.create(timesheet);
        if (ts.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/timesheets/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        timesheetService.delete(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/projects/{name}/timesheets")
    public ResponseEntity<List<Timesheet>> timesheetsByProjectName(@PathVariable String name){
        return ResponseEntity.ok(timesheetService.timesheetsByProjectName(name));
    }

    @GetMapping("/employees/{id}/timesheets")
    public ResponseEntity<List<Timesheet>> timesheetsByEmployeeId (@PathVariable Long id){
        return ResponseEntity.ok(timesheetService.findByEmployeeId(id));
    }
//
//    @GetMapping("/timesheets?createdAtAfter")
//    public ResponseEntity<List<Timesheet>> timesheetsCreatedArter (@RequestParam LocalDate createAtAfter){
//        return ResponseEntity.ok(timesheetService.timesheetsCreatedArter(createAtAfter));
//    }
//
//    @GetMapping("/timesheets?createdAtBefore")
//    public ResponseEntity<List<Timesheet>> timesheetsCreatedBefore (@RequestParam LocalDate createAtBefore){
//        return ResponseEntity.ok(timesheetService.timesheetsCreatedArter(createAtBefore));
//    }
}
