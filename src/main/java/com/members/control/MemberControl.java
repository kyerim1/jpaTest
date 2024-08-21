package com.members.control;

import com.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberControl {

    @Autowired
    private MemberService memberService;

 //회원가입 페이지 요청
    @GetMapping("/signUp")
    public String 회원가입페이지(Model model){

        return "member/signUp";
    }

 //회원가입 요청
    @PostMapping("/signUp")
    public String 회원가입(){

        return "redirect:/";
    }

 //로그인 페이지 요청
    @GetMapping("/signIn")
    public String 로그인페이지(Model model){

        return "member/signIn";
    }

 // 로그인 요청
    @PostMapping("/signIn")
    public String 로그인(){

        return "redirect:/";
    }

 //회원정보수정 페이지 요청
    @GetMapping("/modify")
    public String 회원수정(Model model){

        return "member/signUp";
    }
}
