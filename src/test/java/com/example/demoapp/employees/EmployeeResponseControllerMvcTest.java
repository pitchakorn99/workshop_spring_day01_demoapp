package com.example.demoapp.employees;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(EmployeeController.class)
class EmployeeResponseControllerMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getEmployeeById() throws Exception {

        int id = 100;

        EmployeeResponse mockResponse = new EmployeeResponse();
        mockResponse.setId(id);
        mockResponse.setName("pitchakorn");
        when(employeeService.getById(id)).thenReturn(mockResponse);

        var result = mvc.perform(get("/employees/100"))
                .andExpect(status().is(200))
                .andReturn();

        byte[] json = result.getResponse().getContentAsByteArray();

        EmployeeResponse employeeResponse = mapper.readValue(json, EmployeeResponse.class);

        assertEquals(id, employeeResponse.getId());
        assertEquals("pitchakorn", employeeResponse.getName());
    }
}