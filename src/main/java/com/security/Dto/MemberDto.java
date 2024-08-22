package com.security.Dto;

import com.security.Entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberDto {
    @NotBlank(message="아이디는 필수입니다.")
    private String userId; // 아이디

    @Size(min=4 , max=10 , message="비밀번호는 4~10 자리 구성입니다.")
    private String password; // 비밀번호

    @Min(value=13, message = "13세 이상만 가입 가능합니다.")
    @Max(value=80, message = "80세 이하만 가입 가능합니다.")
    private int age; //나이

    // DTO -> ENTITY
    public Member createEntity(){
        Member member = new Member();
        member.setAge( this.age );
        member.setPassword( this.password );
        member.setUserId( this.userId );
        return member;
    }

    // ENTITY  ->  DTO
    public static MemberDto of(Member member){
        MemberDto memberDto = new MemberDto();
        memberDto.setAge(member.getAge());
        memberDto.setPassword(member.getPassword());
        memberDto.setUserId(member.getUserId());
        return memberDto;
    }
}
