package com.curso.market.persistence.crud;

import com.curso.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    public List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    public Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);

}
