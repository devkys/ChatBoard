package com.example.chat_board.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    @Email
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;
    @NotBlank(message = "비밀번호 항목은 필수 입력 값입니다.")
    private String pw;
    @NotBlank(message = "비밀번호 확인 항목은 필수 입력 값입니다.")
    private String pw_confirm;
    @NotBlank(message = "이름 항목은 필수 입력 값입니다.")
    private String user_name;
    private String phone;

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .pw(pw)
                .user_name(user_name)
                .phone(phone)
                .build();
    }

}
