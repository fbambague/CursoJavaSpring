package com.curso.market.persistence.mapper;

import com.curso.market.domain.DomainCategory;
import com.curso.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoriaId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    DomainCategory toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(DomainCategory category);

}