package com.security.Service;

import com.security.Dto.MemberDto;
import com.security.Entity.Member;
import com.security.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    public void 회원가입처리(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        Member member = memberDto.createEntity(passwordEncoder);

        memberRepository.save(member);

    }

    // 스프링 시큐리티에서  로그인 처리 할때 사용되는 메서드
    //  커스텀 로그인 방식으로 하는경우 서비스크래스 에서 구현 한다.
    // loasUserByUsername 메서드에 매개변수는 로그인 아이디만 받는다.
    //  그래서  회원가입시  아이디가 중복 저장 되지 않도록 해줘야 한다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Member member = memberRepository.findByUserId(username);
            if( member == null){ //로그인을 위해 입력한 아이디가 잘못된 경우
                throw new UsernameNotFoundException(username);
            }
            return User.builder().username(member.getUserId())
                    .password( member.getPassword())
                    .roles( member.getRole().toString())
                    .build();

    }

//    public Boolean 로그인처리(String userId, String password) {
//
//        Member member = memberRepository.findByUserIdAndPassword(userId, password);
//        if( member != null) // 로그인성공
//            return true;
//
//        return false;
//    }
}
