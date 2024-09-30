package com.example.demo.service;

import com.example.demo.models.Timesheet;
import com.example.demo.repository.Timesheetrepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService {

    private final Timesheetrepository timesheetrepository;

    public TimesheetService(Timesheetrepository timesheetrepository) {
        this.timesheetrepository = timesheetrepository;
    }

    public Optional<Timesheet> get (Long id){
      return timesheetrepository.get(id);
    }

    public List<Timesheet> getAll (){
        return timesheetrepository.getAll();
    }

    public Optional<Timesheet> create(Timesheet timesheet){
        timesheet.setCreateAt(LocalDate.now());
        return timesheetrepository.create(timesheet);
    }

    public void delete (Long id) {
        timesheetrepository.delete(id);
    }

    public List<Timesheet> timesheetsByProjectName(String name){
        return timesheetrepository.timesheetsByProjectName(name);
    }

    public List<Timesheet> timesheetsCreatedArter (LocalDate createAtAfter){
        return timesheetrepository.timesheetsCreatedArter(createAtAfter);
    }

    public List<Timesheet> timesheetsCreatedBefore (LocalDate createAtBefore){
        return timesheetrepository.timesheetsCreatedBefore(createAtBefore);
    }
}
