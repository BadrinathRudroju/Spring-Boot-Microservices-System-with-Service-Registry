package com.badrinath.employee_service.repository;

import com.badrinath.employee_service.model.employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class employeeRepository {

    List<employee> employees = new ArrayList<>();

    public void addEmployee(employee employee) {
        employees.add(employee);
    }

    public List<employee> getEmployees() {
        return employees;
    }

    public employee getbyId(Long id) {
        return  employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<employee> findbydepartment(Long department_id) {
        return employees.stream()
                .filter(employee -> employee.department_id().equals(department_id))
                .toList();
    }
}
