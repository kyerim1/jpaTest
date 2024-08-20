package com.jpaTest.service;

import com.jpaTest.Dto.BoardDto;
import com.jpaTest.Dto.BoardListDto;
import com.jpaTest.Entity.Board;
import com.jpaTest.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글목록 불러오기
    public List<BoardListDto>  all(){

        // 1.JPA메서드를 통해 테이블의 전체 데이터 가져오기
        //   전체데이터는 entity객체에 하나씩 저장 되어야 한다.
        List<Board>  boardList = boardRepository.findAll();

        List<BoardListDto> boardListDtos = new ArrayList<>();

        // entity List의 값을  Dto List에 저장하기
        for( Board board : boardList){
            boardListDtos.add( BoardListDto.of(board) );
        }

        return boardListDtos;
    }


    // 새글 작성 데이터베이스에 저장
    public void save(BoardDto boardDto) {
        // 데이터베이스에 저장 될수 있도록  dao클래스의 메서드  호출

        // 1. DTO 객체를 Entity 객체로 저장
        Board board = boardDto.createBoard();

        // 2.JPA 메서드 호출 하기
        boardRepository.save(board);

    }
}
