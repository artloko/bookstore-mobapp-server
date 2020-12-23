package org.bsu.famcs.bookstoremobappserver.controller.v1;

import org.bsu.famcs.bookstoremobappserver.controller.entity.*;
import org.bsu.famcs.bookstoremobappserver.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @GetMapping("/genres")
    @ResponseBody
    public GenresRs getGenres() {
        return catalogService.getGenres();
    }

    @GetMapping("/books")
    @ResponseBody
    public CatalogRs getBooks(@RequestParam String genre,
                              @RequestParam String nameSubstr, @RequestParam String author) {
        return catalogService.getBooks(genre, nameSubstr, author);
    }

    @GetMapping("/books")
    @ResponseBody
    public BookDetailsRs getBookDetails(@RequestParam Long bookId) {
        return catalogService.getBookDetails(bookId);
        //TODO FIX
    }
}
