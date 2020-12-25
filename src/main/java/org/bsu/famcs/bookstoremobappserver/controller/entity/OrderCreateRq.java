package org.bsu.famcs.bookstoremobappserver.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCreateRq {

    private String userId;
    private List<Long> booksId;


}
