package org.bsu.famcs.bookstoremobappserver.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bsu.famcs.bookstoremobappserver.controller.entity.to.BookTO;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersRs {

    private List<BookTO> books;

    public OrdersRs(List<BookTO> books) {
        this.books = books;
    }
}
