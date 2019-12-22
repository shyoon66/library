package com.yoonbae.library.book;

import lombok.Data;

import java.util.List;

@Data
public class KakaoBookResponseDto {
    private KakaoMeta meta;
    private List<KakaoDocuments> documents;
}
