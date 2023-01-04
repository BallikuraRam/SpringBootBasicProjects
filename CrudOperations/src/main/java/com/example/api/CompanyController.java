package com.example.api;

import com.example.model.Company;
import com.example.repository.CompanyRepository;
import com.example.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CompanyController {

    private final CompanyService companyService ;
    private final CompanyRepository companyRepository ;

     //build create Company REST API
    @PostMapping("/post")
    public Company addCompany(@RequestBody Company company)
    {
        return companyService.addCompany(company);
    }

    //build create list of companies REST API
    @PostMapping("/posts")
    public List<Company> addCompanies(@RequestBody List<Company> companyList)
    {
        return companyService.addCompanies(companyList);
    }

    //build get list of company REST API
    @GetMapping("/")
    public List<Company> getAllCompanies()
    {
        return companyService.getCompany();
    }

    //build get company by id  REST API
    @GetMapping("/{id}")
    public Optional<Company> getCompanyByid(@PathVariable(value = "id") int id )
    {
        return companyService.getCompanyById(id);
    }

    //build Count all companies  REST API
    @GetMapping("/count")
    public long countAll()
    {
        return companyService.countAllCompany();
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Company> updateCompanyById(@PathVariable int id , @RequestBody Company company) throws Exception {
//        Company company1 = companyRepository.findById(id)
//                .orElseThrow(()-> new Exception("Company not found by id "+id));
//        company1.setId(company.getId());
//        company1.setUserName(company.getUserName());
//        company1.setPassword(company.getPassword());
//        final Company updateCompanyById = companyRepository.save(company1);
//        return ResponseEntity.ok(updateCompanyById);
//    }
}
