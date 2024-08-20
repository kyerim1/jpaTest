package com.jpaTest.Dto;

import com.jpaTest.Entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BoardListDto {
    private int id;  //번호
    private String title; //제목


    //  Entity - > DTO
    public static BoardListDto of(Board board){
        BoardListDto boardListDto= new BoardListDto();
        boardListDto.setId( board.getId() );
        boardListDto.setTitle( board.getTitle() );
        return boardListDto;
    }
}
