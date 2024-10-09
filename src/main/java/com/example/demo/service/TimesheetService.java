package com.example.demo.service;

import com.example.demo.models.Timesheet;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService {

    private final TimesheetRepository timesheetrepository;
    private final EmployeeRepository employeeRepository;

    public TimesheetService(TimesheetRepository timesheetrepository, EmployeeRepository employeeRepository) {
        this.timesheetrepository = timesheetrepository;
        this.employeeRepository = employeeRepository;
    }

    public Optional<Timesheet> get (Long id){
      return timesheetrepository.findById(id);
    }

    public List<Timesheet> getAll (){
//        throw new UnsupportedOperationException();
        return timesheetrepository.findAll();
    }

    public Optional<Timesheet> create(Timesheet timesheet){
        timesheet.setCreateAt(LocalDate.now());
        return Optional.of(timesheetrepository.save(timesheet));
    }

    public void delete (Long id) {
        timesheetrepository.deleteById(id);
    }

    public List<Timesheet> timesheetsByProjectName(String name){
        return timesheetrepository.findByProjectName(name);
    }

    public List<Timesheet> findByEmployeeId (Long employeeId){
        return timesheetrepository.findByEmployeeId(employeeId);
    }
//
//    public List<Timesheet> timesheetsCreatedArter (LocalDate createAtAfter){
//        return timesheetrepository.timesheetsCreatedArter(createAtAfter);
//    }
//
//    public List<Timesheet> timesheetsCreatedBefore (LocalDate createAtBefore){
//        return timesheetrepository.timesheetsCreatedBefore(createAtBefore);
//    }
}
