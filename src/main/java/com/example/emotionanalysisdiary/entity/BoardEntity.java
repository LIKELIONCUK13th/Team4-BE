package com.example.emotionanalysisdiary.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 500)
    private String content;

    @Column(name = "sentiment")
    private String sentiment;

    @Getter
    @Column(name = "score")
    private float score;

    public BoardEntity() {}

    public BoardEntity( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setScore(float score) {
        this.score= score;
    }

}

