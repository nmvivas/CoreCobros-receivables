package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.CompanyDTO;
import com.banquito.cobros.receivables.service.CompanyService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT })
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/search")
    public List<CompanyDTO> getCompaniesByNamePattern(@RequestParam String namePattern) {
        return companyService.getCompaniesByNamePattern(namePattern);
    }

    @GetMapping("/email/{clientEmail}")
    public CompanyDTO getCompanyByClientEmail(@PathVariable String clientEmail) {
        return companyService.getCompanyByClientEmail(clientEmail);
    }
}
