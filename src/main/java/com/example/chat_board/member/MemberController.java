package com.example.chat_board.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("signup")
    public String signup(Model model) {
        model.addAttribute("signupDto", new SignupDto());

        return "member/signup_form";
    }
    // 회원가입
    @PostMapping("signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            // 에러 나도 작성 폼 그대로 유지
            // 에러 나는 이유 signup dto
            model.addAttribute("member", signupDto);

            return "member/signup_form";
        }
        if(!signupDto.getPw_confirm().equals(signupDto.getPw())) {
            bindingResult.rejectValue("pw_confirm", "passwordIncorrect", "2개의 패스워드 불일치");
            return "member/signup_form";
        }
        memberService.signup(signupDto);
        return "member/board";
    }

    @GetMapping("signin")
    public String sign_in(Model model) {
        model.addAttribute("signinDto", new SigninDto());

        return "member/signin";
    }

    @PostMapping("signin")
    public String signin(@Valid  SigninDto signinDto, Model model, HttpServletRequest request) {
        Member memberLog = memberService.signin(signinDto);
        if(memberLog != null) {
            HttpSession session = request.getSession();
            session.setAttribute("member", memberLog);

        }

        else {
            return "member/signin";
        }
        return "member/board";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/member/signin";
    }

}


