package com.yoonbae.library.member;

import com.yoonbae.library.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String nickName;

    private String thumbnailImage;

    @OneToMany(mappedBy = "member")
    private List<Book> books = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public List<Book> getBooks() {
        return books;
    }
}
