package net.employee.ems_backend.service;

import net.employee.ems_backend.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto empDto);
    EmployeeDto getEmployeeById(Long empId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long empId,EmployeeDto updatedEmp);
}
