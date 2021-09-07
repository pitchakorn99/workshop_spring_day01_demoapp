package com.example.demoapp.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //@Query("select * from employee")
    //List<Employee> findAllByIdAndName(int id, String name);
}
