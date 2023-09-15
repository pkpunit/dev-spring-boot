package com.pktech.cruddemo.rest;

import com.pktech.cruddemo.entity.Employee;
import com.pktech.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable Integer employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    //delete by ID

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable int employeeId){

        if(employeeService.findById(employeeId)!= null)
            employeeService.deleteById(employeeId);
        else
            throw new RuntimeException("Employee is not available");
    }

    //update employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee employeeFromDB = employeeService.findById(employee.getId());
        if(employeeFromDB == null)
            throw new RuntimeException("Employee is not present with passed id");
        return employeeService.save(employee);
    }
}
