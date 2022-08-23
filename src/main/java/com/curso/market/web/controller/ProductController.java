package com.curso.market.web.controller;

import com.curso.market.domain.Product;
import com.curso.market.domain.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return new ResponseEntity<>(productService.getByCategory(categoryId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable("productId") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }



}
