package com.app.services;

import com.app.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(String id);

    EmployeeDto getEmployeeById(String id);

    EmployeeDto updateEmployee(String id);

    void deleteEmployee(String id);


}
