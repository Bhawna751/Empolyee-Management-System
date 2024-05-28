package net.employee.ems_backend.service.Imp;

import lombok.AllArgsConstructor;
import net.employee.ems_backend.dto.EmployeeDto;
import net.employee.ems_backend.entity.Employee;
import net.employee.ems_backend.mapper.EmployeeMapper;
import net.employee.ems_backend.repository.EmployeeRepository;
import net.employee.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto empDto) {
        Employee emp= EmployeeMapper.mapToEmployee(empDto);
        Employee savedEmp = employeeRepository.save(emp);//saving to database
        return EmployeeMapper.mapToEmployeeDto(savedEmp);
    }
}
