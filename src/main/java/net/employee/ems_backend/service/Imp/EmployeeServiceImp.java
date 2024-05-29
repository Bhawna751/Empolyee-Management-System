package net.employee.ems_backend.service.Imp;

import lombok.AllArgsConstructor;
import net.employee.ems_backend.dto.EmployeeDto;
import net.employee.ems_backend.entity.Employee;
import net.employee.ems_backend.exception.ResourceNotFoundException;
import net.employee.ems_backend.mapper.EmployeeMapper;
import net.employee.ems_backend.repository.EmployeeRepository;
import net.employee.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long empId) {
        Employee emp = employeeRepository.findById(empId).orElseThrow(()->
                new ResourceNotFoundException("Employee for given id, does not exist" + empId));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> emp = employeeRepository.findAll();
        return emp.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long empId, EmployeeDto updatedEmp) {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                ()->new ResourceNotFoundException("Emp with given id doesn't exist: " + empId)
        );
        emp.setFirstName(updatedEmp.getFirstName());
        emp.setLastName(updatedEmp.getLastName());
        emp.setEmail(updatedEmp.getEmail());

        Employee updatedEmpObj = employeeRepository.save(emp);
        return EmployeeMapper.mapToEmployeeDto(updatedEmpObj);
    }

}
