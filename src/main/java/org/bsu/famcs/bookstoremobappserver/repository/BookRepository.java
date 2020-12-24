package org.bsu.famcs.bookstoremobappserver.repository;

import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select distinct b from Book b inner join fetch b.authors a inner join fetch b.genres g where " +
            "b.name like concat('%', :name, '%') and " +
            "a.name like concat('%', :author, '%') and " +
            "(:genre = '' or g.name = :genre)")
    Iterable<Book> getFilteredBooks(@Param("name") String name, @Param("author") String author, @Param("genre") String genre);

}
