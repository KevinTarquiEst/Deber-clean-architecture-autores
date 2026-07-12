package org.cat.usercleanarchitecture.infraestructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorEntityRepository extends JpaRepository<AutorEntity, UUID> {
}
