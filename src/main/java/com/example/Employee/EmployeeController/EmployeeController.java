package com.example.Employee.EmployeeController;

import com.example.Employee.Employee.Employee;
import com.example.Employee.EmployeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("add")
    public void addEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        employeeService.add(firstName, lastName);
    }

    @GetMapping("remove")
    public void removeEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }
}
