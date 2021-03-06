package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

//    @BeforeEach
//    public void initTestData(){
//        Employee insEmployee = new Employee();
//        insEmployee.setName("pitchakorn");
//        employeeRepository.save(insEmployee);
//    }
    @AfterEach
    public void clearTestData(){
        employeeRepository.deleteAll();
    }

    @Test
    public void listEmployeeTest(){
        EmployeeResponse[] result = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        //Assert
        assertEquals(2, result.length);
        assertEquals(998, result[0].getId());
    }

    @Test
    public void getEmployeeByIdTest(){
        Employee insEmployee = new Employee();
        insEmployee.setName("pitchakorn");
        employeeRepository.save(insEmployee);

        EmployeeResponse result = restTemplate.getForObject("/employees/1", EmployeeResponse.class);
        assertEquals(1, result.getId());
        assertEquals("pitchakorn", result.getName());
    }
}