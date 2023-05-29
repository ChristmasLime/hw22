package com.homework22.homework22.controller;

import com.homework22.homework22.model.Employee;
import com.homework22.homework22.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam Double salary,
                        @RequestParam Integer departmentId) {
        return service.add(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);

    }

}
