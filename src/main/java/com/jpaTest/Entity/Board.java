package com.jpaTest.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="board_test")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="board_id")
    private int id;

    private String writer;

    private String title;
    private String content;
}
/*
    @Column 애너테이션
    @Column(length=50)  ->  varchar(50) 으로 설정
    @Column(nullable = false)  -> null을 허용하지 않는다.
    @Column(name="nick_name")  -> 컬럼명을 지정할 수 있다.
    @Column(updateable = false) -> 해당컬럼은 변경이 불가
    @Column(insertable = false) -> 해당 컬럼에는 데이터 삽입 불가하다.

 */






