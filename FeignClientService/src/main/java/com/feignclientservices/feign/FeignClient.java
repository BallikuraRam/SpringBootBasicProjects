package com.feignclientservices.feign;

import com.feignclientservices.model.Company;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@org.springframework.cloud.openfeign.FeignClient(name = "company" ,url = "localhost:9091/api")
public interface FeignClient {


    //build create Company REST API
    @PostMapping("/post")
    public Company addCompany(@RequestBody Company company);


    //build create list of companies REST API
    @PostMapping("/posts")
    public List<Company> addCompanies(@RequestBody List<Company> companyList);


    //build get list of company REST API
    @GetMapping("/")
    public List<Company> getAllCompanies();


    //build get company by id  REST API
    @GetMapping("/{id}")
    public Optional<Company> getCompanyByid(@PathVariable(value = "id") int id );


    //build Count all companies  REST API
    @GetMapping("/count")
    public long countAll();

}
