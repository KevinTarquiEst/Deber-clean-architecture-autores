package org.cat.usercleanarchitecture.aplication.ports.output;

import org.cat.usercleanarchitecture.domain.model.Autor;

import java.util.List;

public interface AutorPort {
    Autor create(Autor autor);

    List<Autor> findAll();
}
