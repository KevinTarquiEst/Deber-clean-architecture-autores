package org.cat.usercleanarchitecture.infraestructure.adapters.input;

import org.cat.usercleanarchitecture.aplication.ports.input.IAuthorUseCase;
import org.cat.usercleanarchitecture.aplication.ports.input.IBookUseCase;
import org.cat.usercleanarchitecture.domain.model.Author;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AuthorRequest;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AuthorResponse;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.BookResponse;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.AuthorRequestMapper;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.AuthorResponseMapper;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.BookResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final IAuthorUseCase authorUseCase;
    private final IBookUseCase bookUseCase;

    public AuthorController(IAuthorUseCase authorUseCase, IBookUseCase bookUseCase) {
        this.authorUseCase = authorUseCase;
        this.bookUseCase = bookUseCase;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest request) {
        Author author = authorUseCase.create(AuthorRequestMapper.INSTANCE.toAuthor(request));
        return new ResponseEntity<>(AuthorResponseMapper.INSTANCE.toAuthorResponse(author), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findBooksByAuthorNameAndYear(@RequestParam String name, @RequestParam Integer year) {
        List<BookResponse> books = bookUseCase.findByAuthorNameAndYear(name, year).stream().map(BookResponseMapper.INSTANCE::toBookResponse).toList();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
