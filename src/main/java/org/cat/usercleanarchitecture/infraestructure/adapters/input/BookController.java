package org.cat.usercleanarchitecture.infraestructure.adapters.input;

import org.cat.usercleanarchitecture.aplication.ports.input.IBookUseCase;
import org.cat.usercleanarchitecture.domain.model.Book;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.BookRequest;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.BookResponse;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.BookRequestMapper;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.BookResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookUseCase bookUseCase;

    public BookController(IBookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        Book book = bookUseCase.create(BookRequestMapper.INSTANCE.toBook(request));
        return new ResponseEntity<>(BookResponseMapper.INSTANCE.toBookResponse(book), HttpStatus.CREATED);
    }
}
