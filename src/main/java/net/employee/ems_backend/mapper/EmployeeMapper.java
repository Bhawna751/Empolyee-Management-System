package net.employee.ems_backend.mapper;

import net.employee.ems_backend.dto.EmployeeDto;
import net.employee.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee emp){
        return new EmployeeDto(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDto empDto){
        return new Employee(
                empDto.getId(),
                empDto.getFirstName(),
                empDto.getLastName(),
                empDto.getEmail()
        );
    }
}
