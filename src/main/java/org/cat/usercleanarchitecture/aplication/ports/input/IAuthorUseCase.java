package org.cat.usercleanarchitecture.aplication.ports.input;

import org.cat.usercleanarchitecture.domain.model.Author;

import java.util.UUID;

public interface IAuthorUseCase {
    Author create(Author author);
}
