package com.yoonbae.library.book;

import com.yoonbae.library.api.kakao.book.KakaoBookApi;
import com.yoonbae.library.api.kakao.book.KakaoBookRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final KakaoBookApi kakaoBookApi;

    @GetMapping("/book")
    public String bookList(@ModelAttribute KakaoBookRequestDto requestDto, Model model) {
        model.addAttribute("books", kakaoBookApi.getKakaoBook(requestDto));
        log.info("@@@@@ books = {}", model.getAttribute("books"));
        return "index";
    }
}
