package org.cat.usercleanarchitecture.infraestructure.adapters.input;

import org.cat.usercleanarchitecture.aplication.ports.input.IAuthorUseCase;
import org.cat.usercleanarchitecture.domain.model.Author;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AuthorRequest;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AuthorResponse;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.AuthorRequestMapper;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.AuthorResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final IAuthorUseCase authorUseCase;

    public AuthorController(IAuthorUseCase authorUseCase) {
        this.authorUseCase = authorUseCase;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest request) {
        Author author = authorUseCase.create(AuthorRequestMapper.INSTANCE.toAuthor(request));
        return new ResponseEntity<>(AuthorResponseMapper.INSTANCE.toAuthorResponse(author), HttpStatus.CREATED);
    }
}
