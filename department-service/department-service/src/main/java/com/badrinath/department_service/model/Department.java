package com.badrinath.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private long id;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private String name;

    private List<Employee> employees = new ArrayList<Employee>();
}
