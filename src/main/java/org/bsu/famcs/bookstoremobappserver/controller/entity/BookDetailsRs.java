package org.bsu.famcs.bookstoremobappserver.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.bsu.famcs.bookstoremobappserver.controller.entity.to.BookTO;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;


@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDetailsRs extends BookTO {

    private Integer publishingYear;
    private String description;

    public BookDetailsRs(Book book) {
        super(book);
        this.publishingYear = book.getPublishingYear();
        this.description = book.getDescription();
    }

    public BookDetailsRs(String description) {
        this.description = description;
    }
}
