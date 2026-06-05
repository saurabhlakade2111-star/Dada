package com.example.Helloword.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(1L, "Ganesh", "Developer"),
                    new Employee(2L, "Rahul", "Tester"),
                    new Employee(3L, "Amit", "DevOps")
            )
    );

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "service", "Employee Service"
        );
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employees.removeIf(emp -> emp.getId().equals(id));
        return "Employee deleted successfully";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Spring Boot running on AWS ECS 🚀";
    }
}