package com.example.fukushu1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu1.model.Company;
import com.example.fukushu1.repository.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }
    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }
    public Optional<Company> findCompanyById(Long id){
        return companyRepository.findById(id);
    }
    
}
