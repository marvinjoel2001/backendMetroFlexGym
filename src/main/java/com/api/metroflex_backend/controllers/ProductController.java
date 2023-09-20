package com.api.metroflex_backend.controllers;


import com.api.metroflex_backend.models.ProductModel;
import com.api.metroflex_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<ProductModel> getProductById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public ProductModel updateProductById(@RequestBody ProductModel request, @PathVariable("id") Long id) {
        return productService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        boolean ok = productService.deleteProduct(id);
        if (ok) {
            return "Product with id " + id + " deleted";
        } else {
            return "Oops, we have a problem";
        }
    }

}

