package com.curso.market.persistence.crud;

import com.curso.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    public Optional<List<Compra>> findByIdCliente(String idCliente);

}
