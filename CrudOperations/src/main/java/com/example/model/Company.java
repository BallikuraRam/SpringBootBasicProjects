package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Table(name = "Company_TBL") @AllArgsConstructor @NoArgsConstructor @Data @ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String userName;
    private String password ;
}
