package net.employee.ems_backend.service;

import net.employee.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto empDto);
    EmployeeDto getEmployeeById(Long empId);
}
