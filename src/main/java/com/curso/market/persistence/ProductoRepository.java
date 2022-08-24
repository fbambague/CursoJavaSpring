package com.curso.market.persistence;

import com.curso.market.domain.Product;
import com.curso.market.domain.repository.ProductRepository;
import com.curso.market.persistence.crud.ProductoCrudRepository;
import com.curso.market.persistence.entity.Producto;
import com.curso.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;

    public ProductoRepository (ProductoCrudRepository productoCrudRepository,
                               ProductMapper productMapper){
        this.productoCrudRepository = productoCrudRepository;
        this.productMapper = productMapper;
    }


    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public List<Product> getByCategory(int categoryId) {
        return productMapper.toProducts(productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(productoCrudRepository.save(productMapper.toProducto(product)));
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
