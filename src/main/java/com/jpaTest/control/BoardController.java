package com.jpaTest.control;

import com.jpaTest.Dto.BoardDto;
import com.jpaTest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    // localhost:8080
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/community")
    public String cmt(Model model){
        // 작성된 글 가져와서 목록출력
        model.addAttribute("boardListDto", boardService.all() );

        return "board/index";
    }

    //글작성 클릭하여 요청 들어왔다
    @GetMapping("/community/write")
    public String write(Model model){
        model.addAttribute("boardDto", new BoardDto());
        return "board/write";
    }

    @GetMapping("/community/writeSave")
    public String save(@Valid BoardDto boardDto,
              BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors() ){
            return "board/write";
        }

        boardService.save(boardDto);

        return "redirect:/community";
    }

}
