package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeResponseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listEmployeeTest(){
        EmployeeResponse[] result = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        //Assert
        assertEquals(2, result.length);
        assertEquals(998, result[0].getId());
    }

    @Test
    public void getEmployeeByIdTest(){
        EmployeeResponse result = restTemplate.getForObject("/employees/99", EmployeeResponse.class);
        assertEquals(99, result.getId());
    }
}