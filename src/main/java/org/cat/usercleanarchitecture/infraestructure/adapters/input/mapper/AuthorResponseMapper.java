package org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper;

import org.cat.usercleanarchitecture.domain.model.Author;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorResponseMapper {

    AuthorResponseMapper INSTANCE = Mappers.getMapper(AuthorResponseMapper.class);

    AuthorResponse toAuthorResponse(Author author);

    Author toAuthor(AuthorResponse authorResponse);
}
