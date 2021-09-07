package com.example.demoapp.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("ค้นหาข้อมูล employee id = 1")
    public void case01(){
        int id = 1;
        Employee insEmployee = new Employee();
        insEmployee.setName("pitchakorn");
        employeeRepository.save(insEmployee);
        Optional<Employee> employee = employeeRepository.findById(id);
        assertTrue(employee.isPresent());
        assertEquals(1, employee.get().getId());
        assertEquals("pitchakorn", employee.get().getName());
    }

    @Test
    @DisplayName("ค้นหาข้อมูล employee id = 1 ไม่เจอ")
    public void case02(){
        int id = 1;
        Optional<Employee> employee = employeeRepository.findById(id);
        assertTrue(employee.isPresent());
        assertEquals(1, employee.get().getId());
    }
}