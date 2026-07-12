package org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper;

import org.cat.usercleanarchitecture.domain.model.Autor;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AutorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {

    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    AutorResponse toUserRequest(Autor autor);
    Autor toUser(AutorResponse autorResponse);
}
