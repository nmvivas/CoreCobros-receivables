package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.CompanyDTO;
import com.banquito.cobros.receivables.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT })
@RestController
@RequestMapping("/companies")
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
}
