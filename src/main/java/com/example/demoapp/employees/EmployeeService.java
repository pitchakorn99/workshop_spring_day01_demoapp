package com.example.demoapp.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> result = employeeRepository.findAll();
        return result;
    }

    public EmployeeResponse getById(int id) {
        /*EmployeeResponse employeeResponse1 = new EmployeeResponse();
        employeeResponse1.setId(id);
        employeeResponse1.setName("Pitchakorn");*/

        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            EmployeeResponse response = new EmployeeResponse();
            response.setId(result.get().getId());
            response.setName(result.get().getName());
            return response;
        }
        throw new EmployeeNotFoundException("Employee not found id=" + id);
    }


}
