package org.cat.usercleanarchitecture.aplication.usecases;

import org.cat.usercleanarchitecture.aplication.ports.input.IBookUseCase;
import org.cat.usercleanarchitecture.aplication.ports.output.AuthorPort;
import org.cat.usercleanarchitecture.aplication.ports.output.BookPort;
import org.cat.usercleanarchitecture.domain.model.Book;
import org.cat.usercleanarchitecture.domain.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.List;

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
        AuthorService.validateExists(authorPort.findById(book.getAuthorId()));
        return bookPort.create(book);
    }

    @Override
    public List<Book> findByAuthorNameAndYear(String name, Integer year) {
        return bookPort.findByAuthorNameAndYear(name, year);
    }
}
