package com.jacaranda.employeeProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getCompanies(){
		return companyRepository.findAll();
	}
	
	public Company addCompany(Company neCompany){
		return companyRepository.save(neCompany);
	}
	
	public void deleteCompany(Integer companyId) {
        companyRepository.deleteById(companyId);
    }
	
	public Optional<Company> findById(Integer id) {
		return companyRepository.findById(id);		
	}
}
