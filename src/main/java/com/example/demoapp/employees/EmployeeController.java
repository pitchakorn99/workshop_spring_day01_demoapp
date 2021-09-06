package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public Employee[] listEmployee(){
        Employee employee1 = new Employee();
        employee1.setId(999);
        employee1.setName("Pitchakorn");
        
        Employee[] employees = new Employee[]{employee1};
        return employees;
    }
}
