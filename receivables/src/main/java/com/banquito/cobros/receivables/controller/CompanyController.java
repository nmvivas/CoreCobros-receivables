package com.banquito.cobros.receivables.controller;

import com.banquito.cobros.receivables.dto.CompanyDTO;
import com.banquito.cobros.receivables.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompanyById(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        CompanyDTO updatedCompany = companyService.updateCompanyById(id, companyDTO);
        return ResponseEntity.ok(updatedCompany);
    }
}
