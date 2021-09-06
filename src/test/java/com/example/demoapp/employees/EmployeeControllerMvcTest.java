package com.example.demoapp.employees;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerMvcTest {
    @Autowired
    private MockMvc mvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getEmployeeById() throws Exception {
         var result = mvc.perform(get("/employees/100"))
                .andExpect(status().is(200))
                .andReturn();

         byte[] json = result.getResponse().getContentAsByteArray();

        Employee employee = mapper.readValue(json, Employee.class);

        assertEquals(100, employee.getId());
        assertEquals("pitchakorn", employee.getName());
    }
}