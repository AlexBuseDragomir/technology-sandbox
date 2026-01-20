package com.example.employees.controller;

import com.example.employees.dto.EmployeeDto;
import com.example.employees.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService service;

  @Autowired
  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
    EmployeeDto saved = service.addEmployee(employeeDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    return ResponseEntity.ok(service.getAllEmployees());
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getEmployeeById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmployeeDto> updateEmployee(
      @PathVariable Integer id,
      @Valid @RequestBody EmployeeDto employee) {
    return ResponseEntity.ok(service.updateEmployee(id, employee));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
    service.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
}
