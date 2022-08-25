package com.curso.market.persistence;

import com.curso.market.domain.Purchase;
import com.curso.market.domain.repository.PurchaseRepository;
import com.curso.market.persistence.crud.CompraCrudRepository;
import com.curso.market.persistence.entity.Compra;
import com.curso.market.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private CompraCrudRepository compraCrudRepository;
    private PurchaseMapper purchaseMapper;

    public CompraRepository(CompraCrudRepository compraCrudRepository,
                            PurchaseMapper purchaseMapper){
        this.compraCrudRepository = compraCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return purchaseMapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClientId(String clientId) {
        Optional<List<Compra>> compras = compraCrudRepository.findByIdCliente(clientId);
        return compras.map(compras1 -> purchaseMapper.toPurchases(compras1));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getComprasProductos().forEach(comprasProducto -> comprasProducto.setCompra(compra));

        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
