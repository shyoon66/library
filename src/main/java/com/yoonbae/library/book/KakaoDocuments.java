package com.yoonbae.library.book;

import lombok.Data;

import java.util.List;

@Data
public class KakaoDocuments {
    private String title;
    private String contents;
    private String url;
    private String isbn;
    private String datetime;
    private List<String> authors;
    private String publisher;
    private List<String> translators;
    private Integer price;
    private Integer sale_price;
    private String thumbnail;
    private String status;
}
