package org.cat.usercleanarchitecture.aplication.ports.output;

import org.cat.usercleanarchitecture.domain.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookPort {
    Book create(Book book);

    List<Book> findByAuthorAndYear(UUID authorId, Integer year);
}
