package com.example.webflux.service;

import com.example.webflux.model.Product;
import com.example.webflux.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public Mono<Product> saveProduct(Product product) {
        return repository.save(product);
    }

    public Mono<Void> deleteProduct(String id) {
        return repository.deleteById(id);
    }
}
