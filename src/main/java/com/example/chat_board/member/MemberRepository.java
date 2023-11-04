package com.example.chat_board.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    // 이메일 중복확인
    boolean existsByEmail (String email);

    Optional<Member> findByEmail(String email);

}
