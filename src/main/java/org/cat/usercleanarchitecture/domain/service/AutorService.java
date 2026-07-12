package org.cat.usercleanarchitecture.domain.service;

import org.cat.usercleanarchitecture.domain.model.Autor;

import java.util.List;

public class AutorService {
    public static List<Autor> findByLastName(List<Autor> autors, String lastName) {
        if (autors == null || lastName == null || lastName.isBlank()) return List.of();

        String lastNameToFind = lastName.trim();
        return autors.stream()
                .filter(user -> user != null && user.getLastName() != null)
                .filter(user -> user.getLastName().equalsIgnoreCase(lastNameToFind))
                .toList();
    }
}
