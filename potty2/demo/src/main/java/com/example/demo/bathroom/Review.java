package com.example.demo.bathroom;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long reviewId;

    @Column(name="content")
    String Content;

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Review(String content, String author) {

        Content = content;
        Author = author;
    }

    @Column(name="author")
    String Author;


}
