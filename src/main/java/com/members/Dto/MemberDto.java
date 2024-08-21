package com.members.Dto;


import com.members.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private int id;
    private String userId;
    private String password;
    private String tel;

    public static MemberDto of(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setTel(member.getTel());
        memberDto.setPassword(member.getPassword());
        memberDto.setUserId(member.getUserId());
        return memberDto;
    }


    // DTO -> ENTITY
    public Member createEntity(){
        Member member = new Member();
        member.setId( this.id );
        member.setTel( this.tel );
        member.setUserId( this.userId );
        member.setPassword(this.password);
        return member;
    }
}





