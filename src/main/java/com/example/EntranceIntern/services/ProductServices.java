package com.example.EntranceIntern.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EntranceIntern.model.Product;
import com.example.EntranceIntern.repository.ProductRepository;

@Service
public class ProductServices {
    

    @Autowired ProductRepository repo;


    public List<Product> findAll(){

        return repo.findAll();
    }

    public ResponseEntity<Product> create(Product product){

        Product newProduct = repo.save(product);

        URI uri = URI.create("http://localhost:8080/api/v1/products/" + newProduct.getId());
        
        return ResponseEntity.created(uri).body(product);
    }

    public ResponseEntity<Product> findById(Integer id){

        Product product = repo.findById(id).get();

        return ResponseEntity.ok(product);
    }

    public ResponseEntity<Product> update(Integer id, Product product){

        Product newProduct = repo.findById(id).get();

        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());

        repo.save(newProduct);

        return ResponseEntity.ok(newProduct);
    }

    public ResponseEntity<Product> delete(Integer id){

        Product product = repo.findById(id).get();

        repo.delete(product);

        return ResponseEntity.ok(product);
    }




}
