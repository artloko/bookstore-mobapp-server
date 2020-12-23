package org.bsu.famcs.bookstoremobappserver.repository;

import org.bsu.famcs.bookstoremobappserver.repository.entity.Favorite;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

    Iterable<Favorite> findByUserEntity_Email(String userEmail);
}
