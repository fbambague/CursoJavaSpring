package com.curso.market.persistence.mapper;

import com.curso.market.domain.Purchase;
import com.curso.market.domain.PurchaseItem;
import com.curso.market.persistence.entity.Compra;
import com.curso.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}) //Agregar uses = PurchaseItemMapper.class
public interface PurchaseItemMapper {


    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);
    List<PurchaseItem> toPurchasesItems(List<ComprasProducto> comprasProductos);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "compra",ignore = true),
        @Mapping(target = "producto",ignore = true),
        @Mapping(target = "id.idCompra",ignore = true),

    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
    List<ComprasProducto> toComprasProductos(List<PurchaseItem> purchaseItems);

}
