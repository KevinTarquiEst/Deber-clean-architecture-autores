package org.cat.usercleanarchitecture.infraestructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookEntityRepository extends JpaRepository<BookEntity, UUID> {
    @Query("""
            select book
            from BookEntity book
            where book.year = :year
            and (
                lower(book.author.firstName) like lower(concat('%', :name, '%'))
                or lower(book.author.lastName) like lower(concat('%', :name, '%'))
                or lower(concat(book.author.firstName, ' ', book.author.lastName)) like lower(concat('%', :name, '%'))
            )
            """)
    List<BookEntity> findByAuthorNameAndYear(@Param("name") String name, @Param("year") Integer year);
}
