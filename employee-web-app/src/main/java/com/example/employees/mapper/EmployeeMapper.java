package com.example.employees.mapper;

import com.example.employees.dto.EmployeeDto;
import com.example.employees.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class EmployeeMapper {

  public List<EmployeeDto> mapToDtos(List<Employee> employees) {
    if (isNull(employees) || employees.isEmpty()) {
      return new ArrayList<>();
    }
    return employees.stream().map(this::mapToDto).toList();
  }

  public List<Employee> mapToDos(List<EmployeeDto> employeeDtos) {
    if (isNull(employeeDtos) || employeeDtos.isEmpty()) {
      return new ArrayList<>();
    }
    return employeeDtos.stream().map(this::mapToDo).toList();
  }

  public EmployeeDto mapToDto(Employee employee) {
    if (isNull(employee)) {
      return null;
    }

    return EmployeeDto.builder()
        .id(employee.getId())
        .name(employee.getName())
        .department(employee.getDepartment())
        .salary(employee.getSalary())
        .build();
  }

  public Employee mapToDo(EmployeeDto employeeDto) {
    if (isNull(employeeDto)) {
      return null;
    }

    return Employee.builder()
        .id(employeeDto.id())
        .name(employeeDto.name())
        .department(employeeDto.department())
        .salary(employeeDto.salary())
        .build();
  }
}
