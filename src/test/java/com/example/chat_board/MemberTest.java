package com.example.chat_board;

import com.example.chat_board.member.Member;
import com.example.chat_board.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberRepository repo;

    @Test
    public void memberTest(){
        // 필수 필드값만 지정해서 테스트
        Member member = Member.builder().user_id("kks").pw("1234").user_name("kks2").build();
        Member member2 = Member.builder().user_id("").pw("1234").user_name("kks2").build();

        repo.save(member);

    }
}
