package org.cat.usercleanarchitecture.infraestructure.adapters.output.mapper;

import org.cat.usercleanarchitecture.domain.model.Author;
import org.cat.usercleanarchitecture.infraestructure.adapters.output.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorEntityMapper {

    AuthorEntityMapper INSTANCE = Mappers.getMapper(AuthorEntityMapper.class);

    @Mapping(target = "books", ignore = true)
    AuthorEntity toAuthorEntity(Author author);

    Author toAuthor(AuthorEntity authorEntity);
}
