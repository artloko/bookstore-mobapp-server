package org.bsu.famcs.bookstoremobappserver.service;

import org.bsu.famcs.bookstoremobappserver.repository.*;
import org.bsu.famcs.bookstoremobappserver.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    AuthorRepository authorRepository;

    BookRepository bookRepository;

    FavoriteRepository favoriteRepository;

    GenreRepository genreRepository;

    OrderRepository orderRepository;

    UserRepository userRepository;

    @Autowired
    private TestService(AuthorRepository authorRepository, BookRepository bookRepository, FavoriteRepository favoriteRepository,
                        GenreRepository genreRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.favoriteRepository = favoriteRepository;
        this.genreRepository = genreRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Favorite> getFavorites() {
        return favoriteRepository.findAll();
    }

    public Iterable<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

}
