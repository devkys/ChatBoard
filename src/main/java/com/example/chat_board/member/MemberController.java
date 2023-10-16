package com.example.chat_board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("signup")
    public String signup(Member member) {
        return "/member/signup_form";
    }
    // 회원가입
    @PostMapping("signup")
    public String signup(@ModelAttribute SignupDto signupDto, Model model, BindingResult bindingResult) {
        int result = memberService.signup(signupDto);

        if(result == 0) {
            bindingResult.addError(new FieldError("signup", "password", "비밀번호 확인해주세요"));
        }

        if(bindingResult.hasErrors()) {
            return "/member/signup_form";
        }



//        Member member = signupDto.toEntity();
//        memberService.signup(member);
//        String url = "";
//        int result = memberService.signup(memberDTO);
//        System.out.println("member : " + memberDTO.getUser_name());
//        if (result == 1) {
//            url = "/member/board.html";
//        } else {
//            url = "redirect:/signup_form.html";
//        }
//        model.addAttribute("join", memberDTO);
//        return url;
        model.addAttribute("member", signupDto);
//        Member member2 = Member.builder()
//                .user_id(member.getUser_id())
//                .pw(member.getPw())
//                .user_name(member.getUser_name())
//                .build();
        return "easy";
    }



}


