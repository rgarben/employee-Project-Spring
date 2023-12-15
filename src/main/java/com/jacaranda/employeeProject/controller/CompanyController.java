package com.jacaranda.employeeProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.employeeProject.model.Company;
import com.jacaranda.employeeProject.service.CompanyService;


@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/listCompanies")
	public String listCompanies (Model model) {
		List<Company> listCompanies = companyService.getCompanies();
		model.addAttribute("listCompanies", listCompanies);
		return "listCompanies";
	}
	
	@GetMapping(("/addCompany"))
	public String addCompany(Model model) {
		Company company = new Company();
		model.addAttribute("company", company);
		return "addCompany";
	}
	
	@GetMapping("/addedCompany")
	public String saveCompany(Model model, @ModelAttribute("company") Company nCompany) {
	    companyService.addCompany(nCompany);
	    return "redirect:/listCompanies"; // Redirige a la lista de compañías
	}
	
	@GetMapping("/confirmDelete/{companyId}")
	public String confirmDelete(@PathVariable Integer companyId, Model model) {
	    model.addAttribute("companyId", companyId);
	    return "confirmDelete";
	}
	
	@GetMapping("/confirmDelete/{companyId}/ok")
	public String deleteCompany(@PathVariable Integer companyId, Model model) {
	    model.addAttribute("companyId", companyId);
	    companyService.deleteCompany(companyId);
	    return "redirect:/listCompanies";
	}
	
	@GetMapping("/editCompany/{companyId}")
	public String editCompany(@PathVariable Integer companyId, Model model) {
		Company company = companyService.findById(companyId).orElse(null);
		model.addAttribute("company", company);
		return "editCompany";
	}
	
	@GetMapping("/editCompany/{companyId}/edit")
	public String editCompany(Model model, @ModelAttribute("company") Company nCompany) {
		companyService.addCompany(nCompany);
		return "editCompany";
	}
	
}
