package org.cat.usercleanarchitecture.aplication.ports.input;

import org.cat.usercleanarchitecture.domain.model.Book;

import java.util.List;
import java.util.UUID;

public interface IBookUseCase {
    Book create(Book book);

    List<Book> findByAuthorAndYear(UUID authorId, Integer year);
}
