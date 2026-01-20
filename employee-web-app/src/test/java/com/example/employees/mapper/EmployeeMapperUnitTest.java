package com.example.employees.mapper;

import com.example.employees.dto.EmployeeDto;
import com.example.employees.entity.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeMapperUnitTest {

  private final EmployeeMapper employeeMapper = new EmployeeMapper();

  @Test
  void testMapToDto() {
    // given
    final Employee employee = Employee.builder()
        .id(1)
        .name("John")
        .department("IT")
        .salary(BigDecimal.valueOf(10_000))
        .build();

    // when
    final EmployeeDto employeeDto = employeeMapper.mapToDto(employee);

    // then
    assertThat(employeeDto).isNotNull();
    assertThat(employeeDto.id()).isEqualTo(1);
    assertThat(employeeDto.name()).isEqualTo("John");
    assertThat(employeeDto.department()).isEqualTo("IT");
    assertThat(employeeDto.salary()).isEqualTo(BigDecimal.valueOf(10_000));
  }
}