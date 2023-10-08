package com.example.chat_board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("signup")
    public String signup(MemberDTO memberDTO) {
        String code = "";
        int result = memberService.signup(memberDTO);
        if (result == 1) {
            code = "회원 가입 성공";
        } else {
            code = "해당 아이디 이미 사용 중";
        }
        return code;
    }


}


