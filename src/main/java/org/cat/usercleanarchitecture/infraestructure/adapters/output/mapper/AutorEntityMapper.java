package org.cat.usercleanarchitecture.infraestructure.adapters.output.mapper;

import org.cat.usercleanarchitecture.domain.model.Autor;
import org.cat.usercleanarchitecture.infraestructure.adapters.output.AutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutorEntityMapper {

    AutorEntityMapper INSTANCE = Mappers.getMapper(AutorEntityMapper.class);

    AutorEntity toUserEntity(Autor autor);
    Autor toUser(AutorEntity autorEntity);
}
