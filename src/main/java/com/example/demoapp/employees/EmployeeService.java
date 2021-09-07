package com.example.demoapp.employees;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public EmployeeResponse getById(int id){
        EmployeeResponse employeeResponse1 = new EmployeeResponse();
        employeeResponse1.setId(id);
        employeeResponse1.setName("Pitchakorn");

        return employeeResponse1;
    }
}
