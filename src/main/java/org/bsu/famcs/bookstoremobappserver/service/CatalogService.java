package org.bsu.famcs.bookstoremobappserver.service;

import org.apache.catalina.User;
import org.bsu.famcs.bookstoremobappserver.controller.entity.BookDetailsRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.CatalogRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.FavoriteInsertRq;
import org.bsu.famcs.bookstoremobappserver.controller.entity.GenresRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.to.BookTO;
import org.bsu.famcs.bookstoremobappserver.repository.*;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Author;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Favorite;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CatalogService {

    Logger logger = LoggerFactory.getLogger(CatalogService.class.getName());

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public CatalogService(BookRepository bookRepository, GenreRepository genreRepository,
                          AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    public GenresRs getGenres() {
        return new GenresRs(StreamSupport.stream(genreRepository.findAll().spliterator(), false)
                .map(Genre::getName)
                .collect(Collectors.toList()));
    }

    public CatalogRs getBooks(String genreName, String nameSubstr, String authorName) {


        return new CatalogRs(StreamSupport
                .stream(bookRepository
                        .getFilteredBooks(
                                nameSubstr != null ? nameSubstr : "",
                                authorName != null ? authorName : "",
                                genreName != null ? genreName : "")
                        .spliterator(), false)
                .map(BookTO::new)
                .collect(Collectors.toList()));
    }

    public BookDetailsRs getBookDetails(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null)
            return new BookDetailsRs(book);
        else
            return new BookDetailsRs("There is no book such book");
    }
}
