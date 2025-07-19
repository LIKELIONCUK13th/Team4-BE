package com.example.emotionanalysisdiary.dto;

public class EmotionResponseDto {
    private String sentiment;
    private float score;

    public EmotionResponseDto() {}

    public EmotionResponseDto(String sentiment, float score) {
        this.sentiment = sentiment;
        this.score = score;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
