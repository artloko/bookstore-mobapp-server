package org.bsu.famcs.bookstoremobappserver.repository;

import org.bsu.famcs.bookstoremobappserver.repository.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByNameContaining(String name);
}
