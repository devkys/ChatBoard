package com.example.chat_board.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    private String user_id;
    private String pw;
    private String pw_confirm;
    private String user_name;
    private String addr;
    private String phone;
    private String email;
}
