package org.bsu.famcs.bookstoremobappserver.controller.entity.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Author;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Genre;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookTO {

    private Long bookId;
    private String name;
    private Set<String> authorsList;
    private Set<String> genresList;
    private boolean isOrderAvailable;

    private String imgUrl;

    public BookTO(Book book) {
        this.bookId = book.getId();
        this.name = book.getName();
        this.authorsList = book.getAuthors().stream().map(Author::getName).collect(Collectors.toSet());
        this.genresList = book.getGenres().stream().map(Genre::getName).collect(Collectors.toSet());
        this.isOrderAvailable = book.getQuantity() > 0;
        this.imgUrl = book.getImageUrl();
    }

}
