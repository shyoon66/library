package com.yoonbae.library.api.kakao.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class KakaoBookApi {
    private final String HOST = "https://dapi.kakao.com/v3/search/book";
    private final String APP_KEY = "KEY";

    public KakaoBookResponseDto getKakaoBook(KakaoBookRequestDto bookRequestDto) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(HOST)
                .queryParam("target", bookRequestDto.getTarget())
                .queryParam("query", bookRequestDto.getQuery())
                .queryParam("sort", bookRequestDto.getSort())
                .queryParam("page", bookRequestDto.getPage())
                .queryParam("size", bookRequestDto.getSize());

        HttpHeaders headers = getHttpHeaders();
        log.info("@@@@@@@@@@@@@ headers = {}", headers);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(builder.build().toUriString(), HttpMethod.GET, httpEntity, KakaoBookResponseDto.class).getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + APP_KEY);
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
