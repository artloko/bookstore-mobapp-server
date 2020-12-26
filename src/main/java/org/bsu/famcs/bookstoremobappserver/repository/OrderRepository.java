package org.bsu.famcs.bookstoremobappserver.repository;

import org.bsu.famcs.bookstoremobappserver.repository.entity.Order;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Iterable<Order> findByUserEntity_Id(Long userEntity_id);
}
