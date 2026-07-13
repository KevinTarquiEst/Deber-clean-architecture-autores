package org.cat.usercleanarchitecture.aplication.usecases;

import org.cat.usercleanarchitecture.aplication.ports.input.IBookUseCase;
import org.cat.usercleanarchitecture.aplication.ports.output.BookPort;
import org.cat.usercleanarchitecture.aplication.service.AuthorService;
import org.cat.usercleanarchitecture.domain.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookUseCaseImpl implements IBookUseCase {

    private final BookPort bookPort;
    private final AuthorService authorService;

    public BookUseCaseImpl(BookPort bookPort, AuthorService authorService) {
        this.bookPort = bookPort;
        this.authorService = authorService;
    }

    @Override
    public Book create(Book book) {
        authorService.findById(book.getAuthorId());
        return bookPort.create(book);
    }

    @Override
    public List<Book> findByAuthorAndYear(UUID authorId, Integer year) {
        authorService.findById(authorId);
        return bookPort.findByAuthorAndYear(authorId, year);
    }
}
