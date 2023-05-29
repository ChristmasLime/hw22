package com.homework22.homework22.service;

import com.homework22.homework22.exception.EmployeeAlreadyAddedException;
import com.homework22.homework22.exception.EmployeeInvalidInput;
import com.homework22.homework22.exception.EmployeeNotFoundException;
import com.homework22.homework22.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap();

    private String createKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public Employee add(String firstName, String lastName, Double salary, Integer departmentId) {
        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(firstName, lastName), employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        validateInput(firstName, lastName);
        Employee employee = employees.get(createKey(firstName, lastName));
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee remove(String firstName, String lastName) {
        validateInput(firstName, lastName);
        return employees.remove(createKey(firstName, lastName));
    }


    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validateInput(String firstName, String lastName) {
        if(!isAlpha(firstName) && !isAlpha(lastName)){
            throw new EmployeeInvalidInput();
        }
    }
}
