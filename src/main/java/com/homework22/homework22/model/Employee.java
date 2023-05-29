package com.homework22.homework22.model;

import java.util.Objects;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final double salary;
    private final int departmentId;

    public Employee(String firstName, String lastName, double salary, int departmentId) {
        this.firstName =capitalize(firstName.toLowerCase()) ;
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && departmentId == employee.departmentId && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Имя" + firstName +
                "Фамилия" + lastName  +
                "Зарплата=" + salary +
                "Номер отдела" + departmentId ;
    }
}
