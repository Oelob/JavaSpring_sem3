package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.models.Timesheet;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TimesheetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get (@PathVariable Long id){
        Optional<Employee> ts = employeeService.findById(id);
        return ts.map(employee -> ResponseEntity.status(HttpStatus.OK).body(employee)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
      return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Optional<Employee> ts = employeeService.create(employee);
        if (ts.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/projects/{name}/timesheets")
//    public ResponseEntity<List<Timesheet>> timesheetsByProjectName(@PathVariable String name){
//        return ResponseEntity.ok(timesheetService.timesheetsByProjectName(name));
//    }
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
