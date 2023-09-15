package com.pktech.cruddemo.dao;

import com.pktech.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query

        TypedQuery<Employee> query = entityManager.createQuery("From Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        // execute query and get result
        return employees;
    }
}
