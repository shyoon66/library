package com.yoonbae.library.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KakaoBookApiTest {
    private static KakaoBookApi kakaoBookApi;

    @BeforeAll
    static void beforeAll() {
        kakaoBookApi = new KakaoBookApi();
    }

    @Test
    @DisplayName("카카오 도서 API query를 넘기지 않으면 HttpClientErrorException이 발생한다.")
    void getKakaoBookByEmptyQuery() {
        assertThatThrownBy(() -> {
            KakaoBookRequestDto bookRequestDto = new KakaoBookRequestDto();
            KakaoBookResponseDto kakaoBook = kakaoBookApi.getKakaoBook(bookRequestDto);
        }).isInstanceOf(HttpClientErrorException.class)
          .hasMessageContaining("{\"errorType\":\"MissingParameter\",\"message\":\"query parameter required\"}");
    }

    @Test
    @DisplayName("카카오 도서 API 제목 검색으로 \"클린코드\"의 정보를 가져온다.")
    void getKakaoBookByCleanCode() {
        KakaoBookRequestDto bookRequestDto = new KakaoBookRequestDto();
        bookRequestDto.setTarget(KakaoBookTarget.title);
        bookRequestDto.setQuery("클린코드");
        KakaoBookResponseDto kakaoBook = kakaoBookApi.getKakaoBook(bookRequestDto);

        assertThat(kakaoBook).isNotNull();
    }

}
