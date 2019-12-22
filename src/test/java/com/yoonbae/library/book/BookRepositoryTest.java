package com.yoonbae.library.book;

import com.yoonbae.library.member.Member;
import com.yoonbae.library.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("책 등록 테스트")
    public void saveBookTest() {

    }

}