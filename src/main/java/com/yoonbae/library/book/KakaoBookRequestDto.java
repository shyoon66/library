package com.yoonbae.library.book;

import lombok.Data;

@Data
public class KakaoBookRequestDto {
    private String query;
    private String sort = "accuracy";
    private Integer page = 1;
    private Integer size = 10;
    private KakaoBookTarget target;
}
