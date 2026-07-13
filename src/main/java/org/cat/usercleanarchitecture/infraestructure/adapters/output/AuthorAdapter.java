package org.cat.usercleanarchitecture.infraestructure.adapters.output;

import org.cat.usercleanarchitecture.aplication.ports.output.AuthorPort;
import org.cat.usercleanarchitecture.domain.model.Author;
import org.cat.usercleanarchitecture.infraestructure.adapters.output.mapper.AuthorEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuthorAdapter implements AuthorPort {

    private final AuthorEntityRepository repository;

    public AuthorAdapter(AuthorEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author create(Author author) {
        AuthorEntity authorEntity = repository.save(AuthorEntityMapper.INSTANCE.toAuthorEntity(author));
        return AuthorEntityMapper.INSTANCE.toAuthor(authorEntity);
    }

    @Override
    public Optional<Author> findById(UUID id) {
        return repository.findById(id).map(AuthorEntityMapper.INSTANCE::toAuthor);
    }
}
