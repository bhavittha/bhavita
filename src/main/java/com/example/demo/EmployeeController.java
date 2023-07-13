package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final List<Employee> employees= new ArrayList<>();

    {
        employees.add(new Employee("John", "1","Boss"));
        employees.add(new Employee("Ed", "2","Boss2"))
        ;
    }
    @GetMapping
    public List<Employee> getEmployees(){
        return employees;
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id){
        return employees
        .stream()
                .filter(employee-> employee.getId().equals(id))
        .findFirst();
    }

@GetMapping("/{id}/department")
public String getDepartment(@PathVariable String id){
    return employees
            .stream()
            .filter(employee-> employee.getId().equals(id))
            .findFirst().get().getDepartment();
}
}
