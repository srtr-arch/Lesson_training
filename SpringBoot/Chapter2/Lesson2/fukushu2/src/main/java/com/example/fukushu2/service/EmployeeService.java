package com.example.fukushu2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu2.model.Employee;
import com.example.fukushu2.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setDeleted(true);
            employeeRepository.save(employee);

        }
    }
    public Optional<Employee> findEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    public List<Employee> findEmployeesByLastName(String lastName){
        return employeeRepository.findByLastName(lastName);
    }
    public List<Employee> findEmployeesByFirstName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }
    
}
