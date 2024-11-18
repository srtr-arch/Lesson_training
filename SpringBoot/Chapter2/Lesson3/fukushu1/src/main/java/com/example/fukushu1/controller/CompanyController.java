package com.example.fukushu1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fukushu1.model.Company;
import com.example.fukushu1.model.Employee;
import com.example.fukushu1.service.CompanyService;
import com.example.fukushu1.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    

    @GetMapping("")
    public String listCompany(Model model) {
        List<Company> companies = companyService.findAllCompanies();
        model.addAttribute("companies", companies);

        // return "/companies/list";
        return "index";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("company", new Company());
        return "companies/add-form";
    }

    

    @PostMapping("/add")
    public String addEmployee(Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";

    }
    @GetMapping("edit/{id}")
    public String companyEmployeeForm(@PathVariable(name="id")Long id ,Model model){
         Company company = companyService.findCompanyById(id).orElseThrow(()->new EntityNotFoundException());
        model.addAttribute("company", company);
        return "companies/edit";
    }
    @GetMapping("edit")
    public String editCompany(Company company){
        companyService.saveCompany(company);
        return "redirect:/companies";
        
    }
    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable(name="id")Long id){
    Company company = companyService.findCompanyById(id).orElseThrow(()->new EntityNotFoundException());
        company.setDeleted(true);
        companyService.saveCompany(company);
        return "redirect:/companies";
    }


}

