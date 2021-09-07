package com.example.demoapp.employees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int code;
    private String message;
}
