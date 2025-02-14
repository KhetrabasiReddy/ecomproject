package com.khetrabasi.ecomproject.controller;

import com.khetrabasi.ecomproject.model.Product;
import com.khetrabasi.ecomproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        return product != null ? new ResponseEntity<>(product, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<?> addProduct(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile imageFile) throws IOException {
        Product product1 = service.updateProduct(id, product,imageFile);
        if(product1 != null)
            return new ResponseEntity<>("Updated",HttpStatus.OK);

        return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/search?keyword")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }


}
