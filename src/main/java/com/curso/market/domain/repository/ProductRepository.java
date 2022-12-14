package com.curso.market.domain.repository;

import com.curso.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    public List<Product> getAll();
    public List<Product> getByCategory(int categoryId);
    public Optional<List<Product>> getScarseProduct(int quantity);
    public Optional<Product> getProduct(int productId);
    public Product save(Product product);
    public void delete(int productId);


}
