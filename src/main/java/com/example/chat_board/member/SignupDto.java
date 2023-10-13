package com.example.chat_board.member;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    @NotBlank
    private String user_id;
    @NotBlank
    private String pw;
    @NotBlank
    private String pw_confirm;
    @NotBlank
    private String user_name;
    private String addr;
    private String phone;
    private String email;

    public Member toEntity(){
        return Member.builder()
                .user_id(user_id)
                .pw(pw)
                .user_name(user_name)
                .addr(addr)
                .phone(phone)
                .email(email)
                .build();
    }

}
