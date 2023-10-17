package com.example.chat_board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    // 회원 가입
    public int signup(SignupDto signupDto){
        int result;
        // 비밀번호 불일치시 result 값 0 반환

        if(!signupDto.getPw().equals(signupDto.getPw_confirm())) {
            result = 0;
        }
        else {
            Member member = signupDto.toEntity();
            memberRepository.save(member);
            result = 1;
        }
        return result;
    }

    public Map<String, String> validationHandler(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s",error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;

    }
}
