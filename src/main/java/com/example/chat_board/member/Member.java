package com.example.chat_board.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="member")
public class Member {

    @Id
    private String user_id;
    private String user_name;
    private String pw;
    private String addr;
    private String phone;
    private String email;


}
