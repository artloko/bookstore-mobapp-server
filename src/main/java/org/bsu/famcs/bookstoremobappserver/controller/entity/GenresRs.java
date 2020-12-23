package org.bsu.famcs.bookstoremobappserver.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Genre;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenresRs {

    private List<String> genres;

    public GenresRs(List<String> genres) {
        this.genres = genres;
    }
}
