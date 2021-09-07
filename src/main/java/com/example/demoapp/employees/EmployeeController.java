package com.example.demoapp.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee() {
        EmployeeResponse employeeResponse1 = new EmployeeResponse();
        employeeResponse1.setId(999);
        employeeResponse1.setName("Pitchakorn");
        EmployeeResponse employeeResponse2 = new EmployeeResponse();
        employeeResponse1.setId(998);
        employeeResponse1.setName("Pitchakorn 2");

        EmployeeResponse[] employeeResponses = new EmployeeResponse[]{employeeResponse1, employeeResponse2};
        return employeeResponses;
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
        return employeeService.getById((Integer.parseInt(id)));
    }
}
