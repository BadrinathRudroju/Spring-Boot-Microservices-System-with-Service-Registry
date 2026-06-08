package com.badrinath.department_service.controller;

import com.badrinath.department_service.client.employeeClient;
import com.badrinath.department_service.model.Department;
import com.badrinath.department_service.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private employeeClient employeeClient;

    private static final Logger logger
            = (Logger) LoggerFactory.getLogger(DepartmentController.class);
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> findAll() {
        logger.info("department find");
        return departmentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        logger.info("department find: id={}", id);
        return departmentRepository.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Department department) {
        logger.info("Department add: {}",department);
        departmentRepository.addDepartment(department);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllByDepartmentId(){
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> {
            department.setEmployees(
                    employeeClient.findbydepartment(department.getId()));
        });
        return departments;
    }

}
