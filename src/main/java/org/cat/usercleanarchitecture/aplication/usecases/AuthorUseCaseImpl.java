package org.cat.usercleanarchitecture.aplication.usecases;

import org.cat.usercleanarchitecture.aplication.ports.input.IAuthorUseCase;
import org.cat.usercleanarchitecture.aplication.ports.output.AuthorPort;
import org.cat.usercleanarchitecture.domain.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorUseCaseImpl implements IAuthorUseCase {

    private final AuthorPort authorPort;

    public AuthorUseCaseImpl(AuthorPort authorPort) {
        this.authorPort = authorPort;
    }

    @Override
    public Author create(Author author) {
        return authorPort.create(author);
    }
}
