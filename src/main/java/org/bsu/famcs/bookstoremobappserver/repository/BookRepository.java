package org.bsu.famcs.bookstoremobappserver.repository;

import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b inner join fetch Author as a inner join fetch Genre as g where b.name = :name " +
            "and :author like a.name and :genre like g.name")
    Iterable<Book> getFilteredBooks(@Param("name") String name, @Param("author") String author, @Param("genre") String genre);

}
