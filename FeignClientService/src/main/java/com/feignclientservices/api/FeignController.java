package com.feignclientservices.api;

import com.feignclientservices.feign.FeignClient;
import com.feignclientservices.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeignController {

    private final FeignClient feignClient ;

    @GetMapping("/")
    public List<Company> getAllCompanies()
    {
        return feignClient.getAllCompanies();
    }
    @GetMapping("/count")
    public long countAll()
    {
        return feignClient.countAll();
    }
    @GetMapping("{id}")
    public Optional<Company> getCompanyById(@PathVariable int id)
    {
        return feignClient.getCompanyByid(id);
    }
    @PostMapping("/post")
    public Company addCompany(@RequestBody Company company)
    {
        return feignClient.addCompany(company);
    }

}
