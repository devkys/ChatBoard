package com.example.chat_board.member;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name="member")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private Long id;

    @Column(name = "user_id")
    private String user_id; // 필수 매개변수

//    @NotBlank
    @Column(name = "pw")
    private String pw; // 필수 매개변수

//    @NotBlank
    @Column(name = "user_name")
    private String user_name; // 선택적 매개변수

    @Column(name = "addr")
    private String addr; // 선택적 매개변수

    @Column(name = "phone")
    private String phone; // 선택적 매개변수

    @Column(name = "email")
    private String email; // 선택적 매개변수


}
