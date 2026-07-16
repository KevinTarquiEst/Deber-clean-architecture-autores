package org.cat.usercleanarchitecture.aplication.ports.input;

import org.cat.usercleanarchitecture.domain.model.Book;

import java.util.List;

public interface IBookUseCase {
    Book create(Book book);

    List<Book> findByAuthorNameAndYear(String name, Integer year);
}
