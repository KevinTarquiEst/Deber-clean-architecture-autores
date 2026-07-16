package org.cat.usercleanarchitecture.aplication.ports.output;

import org.cat.usercleanarchitecture.domain.model.Book;

import java.util.List;

public interface BookPort {
    Book create(Book book);

    List<Book> findByAuthorNameAndYear(String name, Integer year);
}
