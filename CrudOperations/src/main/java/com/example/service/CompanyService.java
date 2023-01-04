package com.example.service;

import com.example.model.Company;
import com.example.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company addCompany(Company company)
    {
        return companyRepository.save(company);
    }

    public List<Company> addCompanies(List<Company> companyList)
    {
        return companyRepository.saveAll(companyList);
    }

    public List<Company> getCompany()
    {
        return companyRepository.findAll();
    }
    public Optional<Company> getCompanyById(int id )
    {
        return companyRepository.findById(id);
    }
    public long countAllCompany()
    {
        return companyRepository.count();
    }
}
