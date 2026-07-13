package org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper;

import org.cat.usercleanarchitecture.domain.model.Author;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorRequestMapper {

    AuthorRequestMapper INSTANCE = Mappers.getMapper(AuthorRequestMapper.class);

    AuthorRequest toAuthorResponse(Author author);

    @Mapping(target = "id", ignore = true)
    Author toAuthor(AuthorRequest authorRequest);
}
