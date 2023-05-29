package com.homework22.homework22.controller;

import com.homework22.homework22.model.Employee;
import com.homework22.homework22.service.EmployeeDepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("departments")

public class EmployeeDepartmentController {
    private final EmployeeDepartmentService service;

    public EmployeeDepartmentController(EmployeeDepartmentService service) {
        this.service = service;
    }

    @GetMapping("/min-salary")
    public Employee findMinSalary(@RequestParam Integer departmentId) {
        return service.minSalary(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam Integer departmentId) {
        return service.maxSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> findSalaryInDepartment(@RequestParam(required = false) Integer departmentId) {
        return service.salaryInDepartment(departmentId);
    }
}
