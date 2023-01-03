package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.APIResponse;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") @RequiredArgsConstructor
public class ProductController {

    private final ProductService productService ;

    @GetMapping
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSorting(@PathVariable String field) {
        List<Product> allProducts = productService.findAllProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset ,@PathVariable int pageSize) {
        Page<Product> allProducts = productService.findAllProductsWithPagination(offset, pageSize);
        return new APIResponse<>(allProducts.getSize(), allProducts);
    }
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset ,@PathVariable int pageSize, @PathVariable String field) {
        Page<Product> allProducts = productService.findAllProductsWithPaginationAndSort(offset, pageSize, field);
        return new APIResponse<>(allProducts.getSize(), allProducts);
    }

}
