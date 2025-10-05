package com.practice.product_inventory_api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product")
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/product")
    public List<Product> getProduct(){
        return productService.getProduct();
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PutMapping("/product/{id}")
    public Product updateProduct(@Valid @PathVariable Long id, @RequestBody Product Uproduct){
        return productService.updateProduct(id, Uproduct);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @GetMapping("product/lowStock")
    public List<Product> lowStock(){
        return productService.lowStock();
    }
}
