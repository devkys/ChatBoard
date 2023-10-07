package com.example.chat_board.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="member")
public class Member {

    @Id
    @NotBlank
    private String user_id; // 필수 매개변수

    @NotBlank
    private String pw; // 필수 매개변수

    @NotBlank
    private String user_name; // 선택적 매개변수
    private String addr; // 선택적 매개변수
    private String phone; // 선택적 매개변수
    private String email; // 선택적 매개변수

    @Builder
    public Member(String user_id, String pw, String user_name){
       this.user_id = user_id;
       this.pw = pw;
       this.user_name = user_name;
    }
}
