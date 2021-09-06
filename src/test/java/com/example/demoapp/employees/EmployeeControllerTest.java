package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listEmployeeTest(){
        Employee[] result = restTemplate.getForObject("/employees", Employee[].class);
        //Assert
        assertEquals(2, result.length);
        assertEquals(999, result[0].getId());
    }

    @Test
    public void getEmployeeByIdTest(){
        Employee result = restTemplate.getForObject("/employees/99", Employee.class);
        assertEquals(99, result.getId());
    }
}