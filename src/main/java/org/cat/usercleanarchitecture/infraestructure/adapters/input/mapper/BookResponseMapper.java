package org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper;

import org.cat.usercleanarchitecture.domain.model.Book;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookResponseMapper {
    BookResponseMapper INSTANCE = Mappers.getMapper(BookResponseMapper.class);

    BookResponse toBookResponse(Book book);
}
