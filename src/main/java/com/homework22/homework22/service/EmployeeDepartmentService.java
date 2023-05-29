package com.homework22.homework22.service;

import com.homework22.homework22.exception.EmployeeNotFoundException;
import com.homework22.homework22.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeDepartmentService {
    private final EmployeeService service;



    public EmployeeDepartmentService(EmployeeService service) {
        this.service = service;
    }

    public Employee minSalary(Integer departmentId) {
        return service.getAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee maxSalary(Integer departmentId) {
        return service.getAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> salaryInDepartment(Integer departmentId) {
        Stream<Employee> employeeStream = service.getAll().stream();
        if (departmentId != null) {
            employeeStream = employeeStream.filter(e -> e.getDepartmentId() == departmentId);
        }
        List<Employee> employeeList = employeeStream.collect(Collectors.toList());
        return employeeList;
    }


}
