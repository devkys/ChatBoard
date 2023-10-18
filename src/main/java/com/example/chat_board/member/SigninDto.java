package com.example.chat_board.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninDto {
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    private String pw;
}
