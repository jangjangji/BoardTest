package org.test.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBoard {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String writer;
}