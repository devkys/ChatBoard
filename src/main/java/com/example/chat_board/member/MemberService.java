package com.example.chat_board.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    // @autowired를 활용할 필드 주입이 아닌 final + 생성자 주입을 사용
    private final MemberRepository memberRepository;

    // 전체 회원 조회
    public List<Member> getListAll(){
        return memberRepository.findAll();
    }

    /* 이메일 중복 확인 ㅓ*/
//    public void checkEmail(SignupDto signupDto) {
//        boolean emailDuplicate = memberRepository.findByEmail(signupDto.getEmail());
//        if(emailDuplicate) {
//            throw new IllegalStateException("이미 존재하는 이메일입니다.");
//        }
//    }

    /* 패스워드 불일치 판단 */
//    public void passwordConfirm(SignupDto signupDto) {
//        if(!signupDto.getPw_confirm().equals(signupDto.getPw())) {
//            throw new IllegalStateException("패스워드 불일치");
//        }
//    }

    /* 회원가입폼 에러 핸들러 메소드 */
//    public Map<String, String> validationHandler(Errors errors) {
//        Map<String, String> validatorResult = new HashMap<>();
//
//        for(FieldError error : errors.getFieldErrors()) {
//            String validKeyName = String.format("valid_%s",error.getField());
//            validatorResult.put(validKeyName, error.getDefaultMessage());
//        }
//        return validatorResult;
//
//    }

    public void signup(SignupDto signupDto) {

        Member member = signupDto.toEntity();
        memberRepository.save(member);
    }

    public boolean signin(SigninDto signinDto) {
        boolean result = false;

        Member loginMember = memberRepository.findByEmail(signinDto.getEmail());
        if(loginMember == null) {
            result = false;
        }
        if (!loginMember.getPw().equals(signinDto.getPw())){
            result = true;
        }

        return result;
    }
}
