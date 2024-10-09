package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findById (Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll (){
        return employeeRepository.findAll();
    }

    public Optional<Employee> create (Employee employee){
        return Optional.of(employeeRepository.save(employee));
    }

    public void delete (Long id){employeeRepository.deleteById(id);}
}
