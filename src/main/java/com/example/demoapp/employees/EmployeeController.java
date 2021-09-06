package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public Employee[] listEmployee(){
        Employee employee1 = new Employee();
        employee1.setId(999);
        employee1.setName("Pitchakorn");
        Employee employee2 = new Employee();
        employee1.setId(998);
        employee1.setName("Pitchakorn 2");

        Employee[] employees = new Employee[]{employee1, employee2};
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        Employee employee1 = new Employee();
        employee1.setId(Integer.parseInt(id));
        employee1.setName("Pitchakorn");

        return employee1;
    }
}
