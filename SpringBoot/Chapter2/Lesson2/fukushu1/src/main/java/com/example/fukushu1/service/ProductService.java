package com.example.fukushu1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fukushu1.model.Product;
import com.example.fukushu1.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void deleteProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();

            product.setDeleted(true);

            productRepository.save(product);
        }
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
        
    }

    public List<Product>findAllProducts(){
        return productRepository.findAll();
    }
}
