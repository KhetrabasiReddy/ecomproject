package com.khetrabasi.ecomproject.service;

import com.khetrabasi.ecomproject.model.Product;
import com.khetrabasi.ecomproject.repository.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    public List<Product> getAllProducts(){
        return repo.findAll();
    }


    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }
}
