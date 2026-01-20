package com.example.employees.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record EmployeeDto(
    Integer id,
    @NotBlank(message = "Name is mandatory") String name,
    @NotBlank(message = "Department is mandatory") String department,
    @PositiveOrZero(message = "Salary must be >= 0") BigDecimal salary
) {
  public EmployeeDto withId(Integer id) {
    return new EmployeeDto(id, this.name, this.department, this.salary);
  }
}