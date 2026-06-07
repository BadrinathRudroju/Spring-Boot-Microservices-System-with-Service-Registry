package com.badrinath.department_service.repository;

import com.badrinath.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository  {

    private List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }
}
