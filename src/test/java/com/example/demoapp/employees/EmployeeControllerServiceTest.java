package com.example.demoapp.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Success case")
    public void getEmployeeByIdTest() {
        int id = 1;

        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setName("pitchakorn");

        when(employeeRepository.findById(1))
        .thenReturn(Optional.of(mockEmployee));

        EmployeeResponse result = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        assertEquals(1, result.getId());
        assertEquals("pitchakorn", result.getName());
    }
}