package org.bsu.famcs.bookstoremobappserver.controller.entity;

import org.bsu.famcs.bookstoremobappserver.controller.entity.to.BookTO;

import java.util.List;

public class OrdersRs {

    private List<BookTO> books;

    public OrdersRs(List<BookTO> books) {
        this.books = books;
    }
}
