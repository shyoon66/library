package com.yoonbae.library.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("사용자 등록 테스트")
    public void saveTest() {
        Member member = Member.builder()
                .email("shyoon0606@gmail.com")
                .nickName("연탄")
                .thumbnailImage("http://thumbnailImage.com")
                .build();

        Member findMember = memberService.save(member);
        assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
        assertThat(member.getNickName()).isEqualTo(findMember.getNickName());
        assertThat(member.getThumbnailImage()).isEqualTo(findMember.getThumbnailImage());
    }

    @Test
    @DisplayName("사용자 삭제 테스트")
    public void deleteTest() {
        Member member = Member.builder()
                .email("shyoon0606@gmail.com")
                .nickName("연탄")
                .thumbnailImage("http://thumbnailImage.com")
                .build();

        Member findMember = memberService.save(member);
        memberService.delete(findMember);

        Optional<Member> byId = memberRepository.findById(findMember.getId());
        assertThat(byId.isEmpty()).isTrue();
    }

}