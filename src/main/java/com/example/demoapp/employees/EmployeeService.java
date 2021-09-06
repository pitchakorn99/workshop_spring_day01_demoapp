package com.example.demoapp.employees;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public Employee getById(int id){
        Employee employee1 = new Employee();
        employee1.setId(id);
        employee1.setName("Pitchakorn");

        return employee1;
    }
}
