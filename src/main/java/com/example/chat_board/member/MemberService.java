package com.example.chat_board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

        // signupdto -> member entity
        Member member = signupDto.toEntity();
        memberRepository.save(member);
    }

    public Member signin(SigninDto signinDto) {
        Member loginMember = memberRepository.findByEmail(signinDto.getEmail());
        if (!loginMember.getPw().equals(signinDto.getPw())){
            return null;
        }
        else {
            return loginMember;
        }
    }

    /* 아이디 중복 확인 */
    public int idCheck(String email) {
        int result = 1;
        if(memberRepository.findByEmail(email) != null) {
            System.out.println("중복된 아이디");
            result = 0;
        }
        // 반환값이 1일때 아이디 중복이 아님.
       return result;

    }

}
