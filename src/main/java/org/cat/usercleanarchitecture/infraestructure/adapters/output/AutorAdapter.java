package org.cat.usercleanarchitecture.infraestructure.adapters.output;

import org.cat.usercleanarchitecture.aplication.ports.output.AutorPort;
import org.cat.usercleanarchitecture.domain.model.Autor;
import org.cat.usercleanarchitecture.infraestructure.adapters.output.mapper.AutorEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorAdapter implements AutorPort {

    private final AutorEntityRepository repository;

    public AutorAdapter(AutorEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Autor create(Autor autor) {
        AutorEntity autorEntity = repository.save(AutorEntityMapper.INSTANCE.toUserEntity(autor));
        return AutorEntityMapper.INSTANCE.toUser(autorEntity);
    }

    @Override
    public List<Autor> findAll() {
        return repository.findAll().stream()
                .map(AutorEntityMapper.INSTANCE::toUser)
                .toList();
    }
}
