package org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper;

import org.cat.usercleanarchitecture.domain.model.Autor;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AutorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper {

    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

    AutorRequest toUserRequest(Autor autor);
    Autor toUser(AutorRequest autorRequest);
}
