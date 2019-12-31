package com.yoonbae.library.api.kakao.book;

public class KakaoBookRequestDto {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;
    private String target;

    public KakaoBookRequestDto() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "KakaoBookRequestDto{" +
                "query='" + query + '\'' +
                ", sort='" + sort + '\'' +
                ", page=" + page +
                ", size=" + size +
                ", target='" + target + '\'' +
                '}';
    }
}
