package com.members.service;

import com.members.Dto.MemberDto;
import com.members.entity.Member;
import com.members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void 회원가입저장(MemberDto memberDto) {

        Member member = memberDto.createEntity();

        memberRepository.save(member);
    }
}
