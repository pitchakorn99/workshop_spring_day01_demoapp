package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    public void case01(){

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setName("pitchakorn");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(mockEmployee));

        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeService(employeeRepository);
        EmployeeResponse rtesult = employeeService.getById(1);

        assertEquals(1, rtesult.getId());
        assertEquals("pitchakorn", rtesult.getName());
    }

    @Test
    @DisplayName("Failure case")
    public void case02(){

        String message;

        when(employeeRepository.findById(1)).thenReturn(Optional.empty());

        try{
            EmployeeService employeeService = new EmployeeService();
            employeeService.setEmployeeService(employeeRepository);
            EmployeeResponse rtesult = employeeService.getById(1);

            message = null;
        }catch (Exception ex){
            message = ex.getMessage();
        }

        assertEquals("Employee not found id=1", message);
    }
}
