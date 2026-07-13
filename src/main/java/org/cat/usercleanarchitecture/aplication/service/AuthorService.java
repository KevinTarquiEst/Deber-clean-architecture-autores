package org.cat.usercleanarchitecture.aplication.service;

import org.cat.usercleanarchitecture.aplication.ports.output.AuthorPort;
import org.cat.usercleanarchitecture.domain.model.Author;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorService {

    private final AuthorPort authorPort;

    public AuthorService(AuthorPort authorPort) {
        this.authorPort = authorPort;
    }

    public Author findById(UUID authorId) {
        return authorPort.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("El autor no existe."));
    }
}
