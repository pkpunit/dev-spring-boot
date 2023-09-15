package com.pktech.cruddemo.dao;

import com.pktech.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
