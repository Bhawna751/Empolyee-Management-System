package net.employee.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.employee.ems_backend.dto.EmployeeDto;
import net.employee.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
