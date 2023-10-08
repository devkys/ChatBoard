package com.example.chat_board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 전체 회원 조회
    public List<Member> getListAll(){
        return memberRepository.findAll();
    }

    // 회원 가입
    public int signup(MemberDTO memberDTO){
        int result;
        // 비밀번호 불일치시 result 값 0 반환
        if(!memberDTO.getPw().equals(memberDTO.getPw_confirm())) {
            result = 0;
        }
        else {
            Member member = Member.builder().user_id(memberDTO.getUser_id()).pw(memberDTO.getPw()).
                    user_name(memberDTO.getUser_name()).addr(memberDTO.getAddr()).email(memberDTO.getEmail()).phone(memberDTO.getPhone()).build();

            memberRepository.save(member);
            result = 1;
        }
        return result;
    }
}
