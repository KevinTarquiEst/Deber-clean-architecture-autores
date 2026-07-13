package org.cat.usercleanarchitecture.aplication.usecases;

import org.cat.usercleanarchitecture.aplication.ports.input.IBookUseCase;
import org.cat.usercleanarchitecture.aplication.ports.output.AuthorPort;
import org.cat.usercleanarchitecture.aplication.ports.output.BookPort;
import org.cat.usercleanarchitecture.domain.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookUseCaseImpl implements IBookUseCase {

    private final BookPort bookPort;
    private final AuthorPort authorPort;

    public BookUseCaseImpl(BookPort bookPort, AuthorPort authorPort) {
        this.bookPort = bookPort;
        this.authorPort = authorPort;
    }

    @Override
    public Book create(Book book) {
        validateAuthorExists(book.getAuthorId());
        return bookPort.create(book);
    }

    @Override
    public List<Book> findByAuthorAndYear(UUID authorId, Integer year) {
        validateAuthorExists(authorId);
        return bookPort.findByAuthorAndYear(authorId, year);
    }

    private void validateAuthorExists(UUID authorId) {
        if (authorId == null || authorPort.findById(authorId).isEmpty())
            throw new IllegalArgumentException("El autor no existe.");
    }
}
