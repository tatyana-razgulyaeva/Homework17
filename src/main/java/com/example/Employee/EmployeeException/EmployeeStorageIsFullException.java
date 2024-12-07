package com.example.Employee.EmployeeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmployeeStorageIsFullException extends RuntimeException {
}
