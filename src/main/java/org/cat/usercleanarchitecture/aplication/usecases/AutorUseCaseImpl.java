package org.cat.usercleanarchitecture.aplication.usecases;

import org.cat.usercleanarchitecture.aplication.ports.input.IAutorUseCase;
import org.cat.usercleanarchitecture.aplication.ports.output.AutorPort;
import org.cat.usercleanarchitecture.domain.model.Autor;
import org.cat.usercleanarchitecture.domain.service.AutorService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorUseCaseImpl implements IAutorUseCase {

    private final AutorPort autorPort;

    public AutorUseCaseImpl(AutorPort autorPort) {
        this.autorPort = autorPort;
    }

    @Override
    public Autor create(Autor autor) {
        return autorPort.create(autor);
    }

    @Override
    public List<Autor> findByLastName(String lastName) {
        List<Autor> autors = autorPort.findAll();
        return AutorService.findByLastName(autors, lastName);
    }
}
