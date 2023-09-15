package com.pktech.cruddemo.service;

import com.pktech.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
