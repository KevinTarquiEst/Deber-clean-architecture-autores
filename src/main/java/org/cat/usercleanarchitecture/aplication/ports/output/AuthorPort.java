package org.cat.usercleanarchitecture.aplication.ports.output;

import org.cat.usercleanarchitecture.domain.model.Author;

import java.util.Optional;
import java.util.UUID;

public interface AuthorPort {
    Author create(Author author);

    Optional<Author> findById(UUID id);
}
