package com.yoonbae.library.book;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class KakaoBookApi {
    private final String HOST = "https://dapi.kakao.com/v3/search/book";
    private final String APP_KEY = "d85433cfb1b92e0c3cc17be8948f1f00";

    public KakaoBookResponseDto getKakaoBook(KakaoBookRequestDto bookRequestDto) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(HOST)
                .queryParam("target", bookRequestDto.getTarget())
                .queryParam("query", bookRequestDto.getQuery())
                .queryParam("sort", bookRequestDto.getSort())
                .queryParam("page", bookRequestDto.getPage())
                .queryParam("size", bookRequestDto.getSize());

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity, KakaoBookResponseDto.class).getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + APP_KEY);
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}