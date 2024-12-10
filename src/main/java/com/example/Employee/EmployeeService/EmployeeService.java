package com.example.Employee.EmployeeService;

import com.example.Employee.Employee.Employee;
import com.example.Employee.EmployeeException.EmployeeAlreadyAddedException;
import com.example.Employee.EmployeeException.EmployeeNotFoundException;
import com.example.Employee.EmployeeException.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int EMPLOYEE_COUNT = 20;
    private final List<Employee> list = new ArrayList<>(EMPLOYEE_COUNT);

    {
        list.add(new Employee("Ivan", "Ivanov"));
        list.add(new Employee("Petr", "Petrov"));
        list.add(new Employee("Michael", "Jackson"));
    }

    public void add(String firstName, String lastName) {
        if (list.size() >= EMPLOYEE_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (list.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        list.add(employee);
    }

    public void remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (list.contains(employee)) {
            list.remove(employee);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (list.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
