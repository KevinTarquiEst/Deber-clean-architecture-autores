package org.cat.usercleanarchitecture.aplication.ports.input;

import org.cat.usercleanarchitecture.domain.model.Autor;

import java.util.List;

public interface IAutorUseCase {
    Autor create(Autor autor);

    List<Autor> findByLastName(String lastName);
}
