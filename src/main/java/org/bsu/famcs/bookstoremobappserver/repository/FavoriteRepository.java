package org.bsu.famcs.bookstoremobappserver.repository;

import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Favorite;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

    Iterable<Favorite> findByUserEntity_Email(String userEmail);

    Optional<Favorite> findByUserEntityAndBook(UserEntity userEntity, Book book);
}
