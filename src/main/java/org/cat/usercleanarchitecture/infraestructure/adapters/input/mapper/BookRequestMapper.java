package org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper;

import org.cat.usercleanarchitecture.domain.model.Book;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookRequestMapper {
    BookRequestMapper INSTANCE = Mappers.getMapper(BookRequestMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorFirstName", ignore = true)
    @Mapping(target = "authorLastName", ignore = true)
    Book toBook(BookRequest bookRequest);
}
