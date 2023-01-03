package org.example.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service @RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository ;

//    @PostConstruct
//    public void initDB() {
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100),
//                new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        productRepository.saveAll(products);
//    }
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findAllProductsWithSorting(String field)
    {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC , field));
    }

    public Page<Product> findAllProductsWithPagination(int offset , int pageSize)
    {
        Page<Product> products =productRepository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    public Page<Product> findAllProductsWithPaginationAndSort(int offset , int pageSize , String field)
    {
        Page<Product> products =productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }
}
