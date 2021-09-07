package com.example.demoapp.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeResponse> listEmployee() {
        EmployeeResponse employeeResponse1 = new EmployeeResponse();
        employeeResponse1.setId(999);
        employeeResponse1.setName("Pitchakorn");
        EmployeeResponse employeeResponse2 = new EmployeeResponse();
        employeeResponse1.setId(998);
        employeeResponse1.setName("Pitchakorn 2");

        List<EmployeeResponse> employeeResponses = new ArrayList<>();

        employeeService.getAllEmployee().forEach(data -> {
            EmployeeResponse emp = new EmployeeResponse();
            emp.setId(data.getId());
            emp.setName(data.getName());
            employeeResponses.add(emp);
        });

        return employeeResponses;
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
        return employeeService.getById((Integer.parseInt(id)));
    }
}
