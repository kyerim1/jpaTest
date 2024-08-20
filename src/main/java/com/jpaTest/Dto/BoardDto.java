package com.jpaTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private int boardId;
    private String writer;
    private String title;
    private String content;
}
