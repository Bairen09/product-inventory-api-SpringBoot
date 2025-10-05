package com.practice.product_inventory_api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(@Valid Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(()->new RuntimeException("Invalid Id"));
    }

    public Product updateProduct(@Valid Long id, Product Uproduct) {
        Product existing = getProductById(id);
        existing.setName(Uproduct.getName());
        existing.setPrice(Uproduct.getPrice());
        existing.setStock(Uproduct.getStock());
        return productRepo.save(existing);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }


    public List<Product> lowStock() {
        return productRepo.findByStockLessThan(10);
    }
}
