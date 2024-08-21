package com.members.service;

import com.members.Dto.MemberDto;
import com.members.Dto.MemberLoginDto;
import com.members.entity.Member;
import com.members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void 회원가입저장(MemberDto memberDto) {

        Member member = memberDto.createEntity();

        memberRepository.save(member);
    }

    public void 로그인처리(MemberLoginDto memberLoginDto) {
       // select * from member_test where user_id=xxx and password=xxx
        memberRepository.findByUserIdAndPassword(memberLoginDto.getUserId(), memberLoginDto.getPassword());

    }
}
