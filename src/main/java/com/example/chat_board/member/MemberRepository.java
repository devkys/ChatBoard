package com.example.chat_board.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    // 이메일 중복확인
    Member findByEmail (String email);

}
