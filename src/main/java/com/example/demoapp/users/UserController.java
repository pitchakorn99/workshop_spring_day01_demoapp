package com.example.demoapp.users;

import com.example.demoapp.employees.EmployeeResponse;
import com.example.demoapp.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserGateway userGateway;

    @GetMapping("/users/{id}")
    public Optional<Users> getEmployeeById(@PathVariable String id) {
        return userGateway.getPostById(Integer.parseInt(id));
    }
}
