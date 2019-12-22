package com.yoonbae.library.book;

import com.yoonbae.library.entity.BaseEntity;
import com.yoonbae.library.member.Member;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Book extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String title;

    @Length(max = 10)
    private String isbn10;

    @Length(max = 13)
    private String isbn13;

    private String publisher;

    private String person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPerson() {
        return person;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", publisher='" + publisher + '\'' +
                ", person='" + person + '\'' +
                ", member=" + member +
                '}';
    }
}
