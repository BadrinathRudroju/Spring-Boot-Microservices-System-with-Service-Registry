package com.badrinath.employee_service.model;

public record employee(Long id,
                       Long department_id,
                       String name,
                       String last_name,
                       String email) {
}
