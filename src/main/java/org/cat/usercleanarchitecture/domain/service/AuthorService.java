package org.cat.usercleanarchitecture.domain.service;

import org.cat.usercleanarchitecture.domain.model.Author;

import java.util.Optional;

public class AuthorService {

    public static Author validateExists(Optional<Author> author) {
        if (author.isEmpty()) throw new IllegalArgumentException("El autor no existe.");
        return author.get();
    }
}
