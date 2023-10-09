package com.mongodb.demo.controller;

import com.mongodb.demo.entity.Employee;
import com.mongodb.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employeePayload){
        employeeRepository.save(employeePayload);
        return new ResponseEntity<>(employeePayload, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> createEmployee(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }

}
