package org.bsu.famcs.bookstoremobappserver.service;

import org.bsu.famcs.bookstoremobappserver.controller.entity.OrderCreateRq;
import org.bsu.famcs.bookstoremobappserver.controller.entity.OrdersRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.to.BookTO;
import org.bsu.famcs.bookstoremobappserver.repository.BookRepository;
import org.bsu.famcs.bookstoremobappserver.repository.OrderRepository;
import org.bsu.famcs.bookstoremobappserver.repository.UserRepository;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Order;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, BookRepository bookRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void createOrder(OrderCreateRq orderCreateRq) {
        UserEntity userEntity = userRepository.findUserByEmail(orderCreateRq.getUserId());

        for (Long bookId : orderCreateRq.getBooksId()) {
            Optional<Book> cBook = bookRepository.findById(bookId);
            cBook.ifPresent(book -> orderRepository.save(new Order(userEntity, book)));
        }
    }

    public OrdersRs getOrders(String userId) {
        UserEntity userEntity = userRepository.findUserByEmail(userId);
        return new OrdersRs(StreamSupport
                .stream(orderRepository.findByUserEntity(userEntity).spliterator(), false)
                .map(item -> new BookTO(item.getBook()))
                .collect(Collectors.toList()));
    }
}
