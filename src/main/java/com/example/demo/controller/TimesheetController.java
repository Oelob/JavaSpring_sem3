package com.example.demo.controller;

import com.example.demo.models.Timesheet;
import com.example.demo.service.TimesheetService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
//@RequestMapping("/timesheets")
public class TimesheetController {

//    private static Long sequence = 1l;
//    private final List<Timesheet> timesheets = new ArrayList<>();

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

    @GetMapping("/projects/{id}/timesheets")
    public ResponseEntity<List<Timesheet>> timesheetsByProjectId(@PathVariable Long id){
        return ResponseEntity.ok(timesheetService.timesheetsByProjectId(id));
    }

    @GetMapping("/timesheets?createdAtAfter")
    public ResponseEntity<List<Timesheet>> timesheetsCreatedArter (@RequestParam LocalDate createAtAfter){
        return ResponseEntity.ok(timesheetService.timesheetsCreatedArter(createAtAfter));
    }

    @GetMapping("/timesheets?createdAtBefore")
    public ResponseEntity<List<Timesheet>> timesheetsCreatedBefore (@RequestParam LocalDate createAtBefore){
        return ResponseEntity.ok(timesheetService.timesheetsCreatedArter(createAtBefore));
    }


}
