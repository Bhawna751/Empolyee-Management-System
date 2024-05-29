package net.employee.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.employee.ems_backend.dto.EmployeeDto;
import net.employee.ems_backend.mapper.EmployeeMapper;
import net.employee.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/employees")
public class EmployeeController {
    private EmployeeService empSer;
    //Build Add Employee REST Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto){
        EmployeeDto savedEmp = empSer.createEmployee(empDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }
    //Build Get Employee REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long empId){
        EmployeeDto empDto = empSer.getEmployeeById(empId);
        return ResponseEntity.ok(empDto);
    }
    //Build Get All Employees REST API
    @GetMapping 
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> emps = empSer.getAllEmployees();
        return ResponseEntity.ok(emps);
    }
    //Build update employee REST API
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId,
                                                      @RequestBody EmployeeDto updatedEmp){
        EmployeeDto empDto= empSer.updateEmployee(empId,updatedEmp);
        return ResponseEntity.ok(empDto);
    }

}
