package com.example.emotionanalysisdiary.dto;

public class BoardDto {
    public int id;
    public String title;
    public String content;
    private String sentiment;
    private float score;

    public BoardDto(){}

    public BoardDto(int id, String title, String content,String sentiment, float score) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sentiment = sentiment;
        this.score = score;

    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }
}

