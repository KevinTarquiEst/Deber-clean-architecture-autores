package org.cat.usercleanarchitecture.infraestructure.adapters.output.mapper;

import org.cat.usercleanarchitecture.domain.model.Book;
import org.cat.usercleanarchitecture.infraestructure.adapters.output.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookEntityMapper {

    BookEntityMapper INSTANCE = Mappers.getMapper(BookEntityMapper.class);

    @Mapping(target = "author", ignore = true)
    BookEntity toBookEntity(Book book);

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "authorLastName", source = "author.lastName")
    Book toBook(BookEntity bookEntity);
}
