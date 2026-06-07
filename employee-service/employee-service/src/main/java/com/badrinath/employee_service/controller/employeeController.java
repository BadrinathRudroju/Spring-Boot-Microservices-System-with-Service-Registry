package com.badrinath.employee_service.controller;

import com.badrinath.employee_service.model.employee;
import com.badrinath.employee_service.repository.employeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {

    private final static Logger logger = LoggerFactory
            .getLogger(employeeController.class);
    @Autowired
    private employeeRepository employeeRepository;

    public employeeController(employeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public void addemployee(@RequestBody employee employee) {
        logger.info("add employee " + employee);
        employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<employee> findall() {
        logger.info("find all employees");
        return employeeRepository.getEmployees();
    }

    @GetMapping("{id}")
    public employee getemployee(@PathVariable("id") Long id) {
        logger.info("get employee : id={}" , id);
        return employeeRepository.getbyId(id);
    }

    @GetMapping("/department/{id}")
    public List<employee> findbydepartment(@PathVariable("departmentId") Long department_id) {
        logger.info("find employee by department id={}" , department_id);
        return employeeRepository.findbydepartment(department_id);
    }
}
