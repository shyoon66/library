package com.yoonbae.library.book;

import com.yoonbae.library.api.kakao.book.KakaoBookApi;
import com.yoonbae.library.api.kakao.book.KakaoBookRequestDto;
import com.yoonbae.library.api.kakao.book.KakaoBookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final KakaoBookApi kakaoBookApi;

    @GetMapping("/book")
    public KakaoBookResponseDto bookList(@ModelAttribute KakaoBookRequestDto requestDto) {
        return kakaoBookApi.getKakaoBook(requestDto);
    }
}
