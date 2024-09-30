package com.example.demo.repository;

import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@RequiredArgsConstructor
@Repository
public class Timesheetrepository {
    private static Long sequence = 1l;
    private final List<Timesheet> timesheets = new ArrayList<>();



    public Optional<Timesheet> get (Long id){
        return timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public List<Timesheet> getAll (){
        return List.copyOf(timesheets);
    }


    public Optional<Timesheet> create(Timesheet timesheet) {
        if (ProjectRepository.projects.stream()
                .anyMatch(project -> project.getName().equals(timesheet.getProjectName()))) {
            timesheet.setId(sequence++);
            timesheets.add(timesheet);
            return Optional.of(timesheet);
        }
        return Optional.of(timesheet);
    }

    public void delete (Long id){
        timesheets.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .ifPresent(timesheets::remove);
    }

    public List<Timesheet> timesheetsByProjectName(String name){
        return timesheets.stream()
                .filter(it -> it.getProjectName().equals(name)).toList();
    }

    public List<Timesheet> timesheetsCreatedArter (LocalDate createAtAfter){
        return timesheets.stream()
                .filter(it -> it.getCreateAt().isAfter(createAtAfter)).toList();
    }

    public List<Timesheet> timesheetsCreatedBefore (LocalDate createAtBefor){
        return timesheets.stream()
                .filter(it -> it.getCreateAt().isBefore(createAtBefor)).toList();
    }

}
