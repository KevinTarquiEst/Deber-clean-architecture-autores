package org.cat.usercleanarchitecture.infraestructure.adapters.output;

import org.cat.usercleanarchitecture.aplication.ports.output.BookPort;
import org.cat.usercleanarchitecture.domain.model.Book;
import org.cat.usercleanarchitecture.infraestructure.adapters.output.mapper.BookEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookAdapter implements BookPort {

    private final BookEntityRepository bookRepository;
    private final AuthorEntityRepository authorRepository;

    public BookAdapter(BookEntityRepository bookRepository, AuthorEntityRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book create(Book book) {
        AuthorEntity authorEntity = authorRepository.findById(book.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("The author does not exist"));
        BookEntity bookEntityToSave = BookEntityMapper.INSTANCE.toBookEntity(book);
        bookEntityToSave.setAuthor(authorEntity);
        BookEntity bookEntity = bookRepository.save(bookEntityToSave);
        return BookEntityMapper.INSTANCE.toBook(bookEntity);
    }

    @Override
    public List<Book> findByAuthorAndYear(UUID authorId, Integer year) {
        return bookRepository.findByAuthorIdAndYear(authorId, year).stream().map(BookEntityMapper.INSTANCE::toBook).toList();
    }
}
