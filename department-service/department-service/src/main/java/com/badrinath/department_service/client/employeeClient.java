package com.badrinath.department_service.client;

import com.badrinath.employee_service.model.employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface employeeClient {

    @GetExchange("/employee/department/{id}")
    public List<employee> findbydepartment
            (@PathVariable("departmentId") Long department_id);
}
