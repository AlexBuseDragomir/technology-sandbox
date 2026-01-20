package com.example.employees.service;

import com.example.employees.dto.EmployeeDto;
import com.example.employees.entity.Employee;
import com.example.employees.mapper.EmployeeMapper;
import com.example.employees.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

  private static final String EMPLOYEE_COULD_NOT_BE_FOUND =
      "Employee with id [%s] could not be found";

  private final EmployeeRepository repository;
  private final EmployeeMapper mapper;

  @Autowired
  public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public EmployeeDto getEmployeeById(Integer id) {
    final Employee employee = repository.findById(id)
        .orElseThrow(() -> createNotFoundException(id));
    return mapper.mapToDto(employee);
  }

  public List<EmployeeDto> getAllEmployees() {
    return mapper.mapToDtos(repository.findAll());
  }

  public EmployeeDto addEmployee(EmployeeDto toAddDto) {
    final Employee toAddDo = mapper.mapToDo(toAddDto);
    toAddDo.setId(null);

    return mapper.mapToDto(repository.save(toAddDo));
  }

  public EmployeeDto updateEmployee(Integer id, EmployeeDto toUpdateDto) {
    if (!repository.existsById(id)) {
      throw createNotFoundException(id);
    }

    final Employee toUpdateDo = mapper.mapToDo(toUpdateDto);
    toUpdateDo.setId(id);

    return mapper.mapToDto(repository.save(toUpdateDo));
  }

  public void deleteEmployee(Integer id) {
    if (!repository.existsById(id)) {
      throw createNotFoundException(id);
    }
    repository.deleteById(id);
  }

  private ResponseStatusException createNotFoundException(Integer id) {
    final String errorMessage = String.format(EMPLOYEE_COULD_NOT_BE_FOUND, id);
    return new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
  }
}
