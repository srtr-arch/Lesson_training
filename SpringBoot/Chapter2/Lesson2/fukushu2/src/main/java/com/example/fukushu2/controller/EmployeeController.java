package com.example.fukushu2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fukushu2.model.Employee;
import com.example.fukushu2.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String listEmployee(Model model){
        List<Employee>employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }
    @PostMapping("/add")
    public String addEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
       
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable("id")Long id,Model model){
        Optional<Employee>optionalEmployee = employeeService.findEmployeeById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee",employee);
            return "employees/edit";
        }
        return "redirect:/employees";
    }
    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/search")
    public String searchByLastName(@RequestParam(name="lastName",required=false)String lastName,Model model){
        List<Employee>employees = employeeService.findEmployeesByLastName(lastName);
        model.addAttribute("employees", employees);
        return "/employees/search";
    }
    @GetMapping("/search2")
    public String searchByFirstName(@RequestParam(name="firstName",required=false)String firstName,Model model){
    System.out.println(firstName+"!!!!!!!!!!");
    List<Employee>employees = employeeService.findEmployeesByFirstName(firstName);
        model.addAttribute("employees", employees);
        return "/employees/search";
    }
    
    
}
