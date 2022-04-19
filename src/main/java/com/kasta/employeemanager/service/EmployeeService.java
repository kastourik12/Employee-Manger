package com.kasta.employeemanager.service;

import com.kasta.employeemanager.exception.UserNotFoundException;
import com.kasta.employeemanager.model.Employee;
import com.kasta.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository=employeeRepository;
    }
    public Employee addEmlpyee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    public List<Employee> findAllEmployees()
    {
        return employeeRepository.findAll();

    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee findEmployeebyId(Long id){
        return employeeRepository.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException(
                        "user by id"+id+"was not found"));
    }
}
